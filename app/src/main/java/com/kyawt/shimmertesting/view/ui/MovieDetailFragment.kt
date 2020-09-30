package com.kyawt.shimmertesting.view.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.github.florent37.glidepalette.BitmapPalette
import com.github.florent37.glidepalette.GlidePalette
import com.kyawt.shimmertesting.R
import com.kyawt.shimmertesting.service.model.detail.MovieDetail
import com.kyawt.shimmertesting.service.model.movie.MovieResult
import com.kyawt.shimmertesting.service.model.video.Result
import com.kyawt.shimmertesting.service.repository.MovieRepository
import com.kyawt.shimmertesting.view.adapter.SimilarAdapter
import com.kyawt.shimmertesting.view.constant.Constant
import com.kyawt.shimmertesting.view.utils.ShimmerUtils
import com.kyawt.shimmertesting.view.viewholder.SimilarViewHolder
import com.kyawt.shimmertesting.viewmodel.MovieDetailViewModel
import com.kyawt.shimmertesting.viewmodel.SimilarViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_movie_detail.*

class MovieDetailFragment : Fragment(), SimilarViewHolder.OnClickListener {
    lateinit var movieDetailViewModel: MovieDetailViewModel
    lateinit var similarViewModel: SimilarViewModel
    lateinit var similarAdapter: SimilarAdapter
    lateinit var viewManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieDetailViewModel = ViewModelProviders.of(this).get(MovieDetailViewModel::class.java)
        similarViewModel = ViewModelProviders.of(this).get(SimilarViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_detail, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupRecycler()
        detailLayout.shimmer = ShimmerUtils.getGrayShimmer(context!!)
        Handler().postDelayed(
            {
                detailLayout.unVeil()
            }, 4000
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movie = arguments?.getParcelable<MovieResult>(Constant.movie_key)
        movieDetailViewModel.setID(movie!!)

        var movie_id = movie.id
        movieDetailViewModel.loadData(movie_id)
//        movieDetailViewModel.loadVideo(movie_id)
        similarViewModel.loadData(movie_id)
//        loadVideos()
        observeViewModel()
        onBackPressed()
        buttomAction()
    }


    private fun observeViewModel() {
        movieDetailViewModel.detailResult().observe(viewLifecycleOwner, Observer<MovieDetail> {
            val baseUrl = Constant.MOVIE_PATH
            val imgPath = it.backdropPath
            Glide.with(this)
                .load("$baseUrl$imgPath")
                .listener(
                    GlidePalette.with("$baseUrl$imgPath")
                        .use(BitmapPalette.Profile.VIBRANT_LIGHT)
                        .intoBackground(cardDetail)
                        .use(BitmapPalette.Profile.MUTED)
                        .intoTextColor(txtAbout)
                        .intoTextColor(txtMovieType)
                        .intoTextColor(txtYear)
                        .intoTextColor(txtCountry)
                        .intoTextColor(txtLength)
                )
                .into(imgMovie)

            txtMovieTitle.text = it.title
            if (!it.genres[0].name.equals(null)) {
                txtMovieType.text = it.genres[0].name
            } else {
                txtMovieType.visibility = View.GONE
            }
//
//            if (!it.genres[1].name.equals(null)){
//                txtMovieTypeTwo.text = it.genres[1].name
//            }else {
//                txtMovieTypeTwo.visibility = View.GONE
//            }

            txtYearValue.text = it.releaseDate
            if (it.productionCompanies.isNotEmpty()) {
                txtCountryValue.text = it.productionCountries[0].name
            } else {
                txtCountry.visibility = View.GONE
                txtCountryValue.visibility = View.GONE
            }
            txtLengthValue.text = it.runtime + " min"
            txtAbout.text = it.overview
            txtMovieRating.rating = it.popularity.toFloat()
        })

        similarViewModel.similarMovieResult.observe(viewLifecycleOwner, Observer {
            recyclerSimilar.visibility = View.VISIBLE
            similarAdapter.updateList(it.results)

        })

    }
//
//    private fun loadVideos() {
//        val movieRepository = MovieRepository()
//
//        movieDetailViewModel.loadVideo.observe(viewLifecycleOwner, Observer {result ->
//            imgPlay.setOnClickListener {
//                Intent(Intent.ACTION_VIEW, Uri.parse(movieRepository.loadVideo(result.key)))
//            }
//        })
//
//
//    }

    private fun setupRecycler() {
        similarAdapter = SimilarAdapter(this)
        viewManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerSimilar.apply {
            this.adapter = similarAdapter
            this.layoutManager = viewManager
        }
    }

    private fun buttomAction() {
        imgPlay.setOnClickListener {
            imgMovie.visibility = View.GONE
            vdMovie.visibility = View.VISIBLE
        }
    }

    private fun onBackPressed() {
        imgBack.setOnClickListener {
            findNavController().navigate(R.id.action_movieDetailFragment_to_homeFragment,null,navOptions)
        }
    }

    override fun onClick(similar: MovieResult) {
        val bundle = Bundle()
        bundle.putParcelable(Constant.movie_key,similar)
        findNavController().navigate(R.id.action_movieDetailFragment_self,bundle,navOptions)
    }
    val navOptions = NavOptions.Builder()
        .setEnterAnim(R.anim.nav_default_enter_anim)
        .setExitAnim(R.anim.nav_default_exit_anim)
        .setPopEnterAnim(R.anim.nav_default_pop_enter_anim)
        .setPopExitAnim(R.anim.nav_default_pop_exit_anim)
        .build()
}