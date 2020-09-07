package com.kyawt.shimmertesting.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kyawt.shimmertesting.service.model.movie.MovieResult
import com.kyawt.shimmertesting.view.constant.Constant
import kotlinx.android.synthetic.main.item_movie.view.*

class SimilarViewHolder(var v: View,
private val mClickListener : OnClickListener): RecyclerView.ViewHolder(v) {
    fun bind(similar : MovieResult){
        val baseURL = Constant.MOVIE_PATH
        val imgPath = similar.posterPath
        Glide.with(v)
            .load("$baseURL$imgPath")
            .into(v.moviePoster)

        v.rootView.setOnClickListener {
            mClickListener.onClick(similar)
        }
    }

    interface OnClickListener{
        fun onClick(similar: MovieResult)
    }
}