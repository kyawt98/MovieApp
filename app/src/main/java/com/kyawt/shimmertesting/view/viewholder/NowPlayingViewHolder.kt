package com.kyawt.shimmertesting.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kyawt.shimmertesting.service.model.detail.MovieDetail
import com.kyawt.shimmertesting.service.model.movie.MovieResult
import com.kyawt.shimmertesting.view.constant.Constant
import kotlinx.android.synthetic.main.item_movie.view.*

class NowPlayingViewHolder(var v: View,
private var mClickListener: ClickListener): RecyclerView.ViewHolder(v) {
    fun bind(nowPlaying : MovieResult){
        val baseUrl = Constant.MOVIE_PATH
        val imgPath =nowPlaying.posterPath
        Glide.with(v)
            .load("$baseUrl$imgPath")
            .into(v.moviePoster)

        v.rootView.setOnClickListener {
            mClickListener.onClickNowPlaying(nowPlaying)
        }
    }
    interface ClickListener{
        fun onClickNowPlaying(nowPlaying: MovieResult)
    }
}