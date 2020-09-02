package com.kyawt.shimmertesting.view.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.kyawt.shimmertesting.R
import com.kyawt.shimmertesting.view.adapter.*
import com.kyawt.shimmertesting.viewmodel.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    lateinit var popularViewModel: PopularViewModel
    lateinit var nowPlayingViewModel: NowPlayingViewModel
    lateinit var latestViewModel: LatestViewModel
    lateinit var topRatedViewModel: TopRatedViewModel
    lateinit var upcomingViewModel: UpcomingViewModel
    lateinit var topImageViewModel: TopImageViewModel
    lateinit var topImageAdapter: TopImageAdapter
    lateinit var upcomingAdapter: UpcomingAdapter
    lateinit var topRatedAdapter: TopRatedAdapter
    lateinit var popularAdapter: PopularAdapter
    lateinit var nowPlayingAdapter: NowPlayingAdapter
    lateinit var latestAdapter: LatestAdapter
    lateinit var viewManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        popularViewModel = ViewModelProviders.of(this).get(PopularViewModel::class.java)
        nowPlayingViewModel = ViewModelProviders.of(this).get(NowPlayingViewModel::class.java)
        latestViewModel = ViewModelProviders.of(this).get(LatestViewModel::class.java)
        topRatedViewModel = ViewModelProviders.of(this).get(TopRatedViewModel::class.java)
        upcomingViewModel = ViewModelProviders.of(this).get(UpcomingViewModel::class.java)
        topImageViewModel = ViewModelProviders.of(this).get(TopImageViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclers()
        popularViewModel.loadData()
        nowPlayingViewModel.loadData()
        latestViewModel.loadData()
        topRatedViewModel.loadData()
        upcomingViewModel.loadData()
        topImageViewModel.loadData()
        observeViewModel()
    }

    private fun setupRecyclers() {
        recyclerPopular.apply {
            viewManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            popularAdapter = PopularAdapter()
            this.adapter = popularAdapter
            this.layoutManager = viewManager
        }

        recyclerNowPlaying.apply {
            viewManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            nowPlayingAdapter = NowPlayingAdapter()
            this.adapter = nowPlayingAdapter
            this.layoutManager = viewManager
        }

        recyclerLatest.apply {
            viewManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            latestAdapter = LatestAdapter()
            this.adapter = latestAdapter
            this.layoutManager = viewManager
        }

        recyclerTopRated.apply {
            viewManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            topRatedAdapter = TopRatedAdapter()
            this.adapter = topRatedAdapter
            this.layoutManager = viewManager
        }

        recyclerUpcoming.apply {
            viewManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            upcomingAdapter = UpcomingAdapter()
            this.adapter = upcomingAdapter
            this.layoutManager = viewManager
        }

        recyclerTop.apply {
            viewManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            topImageAdapter = TopImageAdapter()
            this.adapter = topImageAdapter
            this.layoutManager = viewManager
        }

    }

    private fun observeViewModel() {
        popularViewModel.popularResult.observe(viewLifecycleOwner, Observer { result ->
            recyclerPopular.visibility = View.VISIBLE
            popularAdapter.updateList(result.results)
        })

        nowPlayingViewModel.nowPlayingResult.observe(viewLifecycleOwner, Observer { result ->
            recyclerNowPlaying.visibility = View.VISIBLE
            nowPlayingAdapter.updateList(result.results)
        })

//        latestViewModel.latestResult.observe(viewLifecycleOwner, Observer { result ->
//            recyclerLatest.visibility = View.VISIBLE
//            latestAdapter.updateList(result.results)
//        })

        topRatedViewModel.topRatedResult.observe(viewLifecycleOwner, Observer { result ->
            recyclerTopRated.visibility = View.VISIBLE
            topRatedAdapter.updateList(result.results)
        })

        upcomingViewModel.upcomingResult.observe(viewLifecycleOwner, Observer { result ->
            recyclerUpcoming.visibility = View.VISIBLE
            upcomingAdapter.updateList(result.results)
        })

        topImageViewModel.topImageResult.observe(viewLifecycleOwner, Observer { result ->
            recyclerTop.visibility = View.VISIBLE
            topImageAdapter.updateList(result.results)
        })
    }

}