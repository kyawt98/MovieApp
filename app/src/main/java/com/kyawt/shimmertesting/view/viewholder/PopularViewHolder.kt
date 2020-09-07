package com.kyawt.shimmertesting.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kyawt.shimmertesting.service.model.movie.MovieResult
import com.kyawt.shimmertesting.service.repository.ServiceProvider
import com.kyawt.shimmertesting.view.constant.Constant
import kotlinx.android.synthetic.main.item_movie.view.*

class PopularViewHolder(var v:View ,
private val mClickListener:ClickListener): RecyclerView.ViewHolder(v){
    fun bind(popular:MovieResult){
        val baseUrl = Constant.MOVIE_PATH
        val imgPath =popular.posterPath
        Glide.with(v)
            .load("$baseUrl$imgPath")
            .into(v.moviePoster)

        v.rootView.setOnClickListener {
            mClickListener.onClick(popular)
        }
    }

    interface ClickListener{
        fun onClick(popular:MovieResult)
    }
}