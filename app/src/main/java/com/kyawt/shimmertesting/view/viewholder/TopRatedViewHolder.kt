package com.kyawt.shimmertesting.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kyawt.shimmertesting.service.model.movie.MovieResult
import kotlinx.android.synthetic.main.item_movie.view.*

class TopRatedViewHolder(var v:View) : RecyclerView.ViewHolder(v) {
    fun bind(topRated: MovieResult){
        val baseUrl = "https://image.tmdb.org/t/p/w500"
        val imgPath =topRated.posterPath

        Glide.with(v)
            .load("$baseUrl$imgPath")
            .into(v.moviePoster)
    }
}