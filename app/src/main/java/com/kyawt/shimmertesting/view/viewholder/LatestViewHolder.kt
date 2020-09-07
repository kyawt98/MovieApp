package com.kyawt.shimmertesting.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kyawt.shimmertesting.service.model.movie.MovieResult
import com.kyawt.shimmertesting.view.constant.Constant
import kotlinx.android.synthetic.main.item_movie.view.*

class LatestViewHolder (var v:View): RecyclerView.ViewHolder(v){
    fun bind(latest : MovieResult){
        val baseUrl = Constant.MOVIE_PATH
        val imgPath =latest.posterPath
        Glide.with(v)
            .load("$baseUrl$imgPath")
            .into(v.moviePoster)
    }
}