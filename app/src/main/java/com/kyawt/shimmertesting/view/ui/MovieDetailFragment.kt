package com.kyawt.shimmertesting.view.ui

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.github.florent37.glidepalette.BitmapPalette
import com.github.florent37.glidepalette.GlidePalette
import com.kyawt.shimmertesting.R
import com.kyawt.shimmertesting.service.model.detail.MovieDetail
import com.kyawt.shimmertesting.service.model.movie.MovieResult
import com.kyawt.shimmertesting.view.constant.Constant
import com.kyawt.shimmertesting.view.utils.ShimmerUtils
import com.kyawt.shimmertesting.viewmodel.MovieDetailViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_movie_detail.*

class MovieDetailFragment : Fragment() {
lateinit var movieDetailViewModel: MovieDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    movieDetailViewModel = ViewModelProviders.of(this).get(MovieDetailViewModel::class.java)
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
        observeViewModel()
        onBackPressed()
        buttomAction()
    }

    private fun observeViewModel(){
        movieDetailViewModel.detailResult().observe(viewLifecycleOwner, Observer<MovieDetail>{
            val baseUrl = "https://image.tmdb.org/t/p/w500"
            val imgPath = it.posterPath
            Glide.with(this)
                .load("$baseUrl$imgPath")
                .listener(GlidePalette.with("$baseUrl$imgPath")
                    .use(BitmapPalette.Profile.MUTED_DARK)
                    .intoBackground(cardDetail))
                .into(imgMovie)


            txtMovieTitle.text = it.title
//            txtMovieType.text = it.genres.listIterator().toString()
            txtYearValue.text = it.releaseDate
//            txtCountryValue.text = it.productionCountries.listIterator().toString()
            txtLengthValue.text = it.runtime+" min"
            txtAbout.text = it.overview
        })
    }

    private fun buttomAction(){
        imgPlay.setOnClickListener {
            imgMovie.visibility = View.GONE
            vdMovie.visibility = View.VISIBLE
        }
    }
    private fun onBackPressed(){
        imgBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}