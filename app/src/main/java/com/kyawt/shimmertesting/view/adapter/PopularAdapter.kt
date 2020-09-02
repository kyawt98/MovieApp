package com.kyawt.shimmertesting.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kyawt.shimmertesting.R
import com.kyawt.shimmertesting.service.model.movie.MovieResult
import com.kyawt.shimmertesting.view.exts.viewBinding
import com.kyawt.shimmertesting.view.viewholder.PopularViewHolder

class PopularAdapter (var popularList: List<MovieResult> = emptyList()) : RecyclerView.Adapter<PopularViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(parent.context.viewBinding(R.layout.item_movie,parent))
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        holder.bind(popularList[position])

    }

    override fun getItemCount(): Int = popularList.size

    fun updateList(popularList: List<MovieResult>){
        this.popularList = popularList
        notifyDataSetChanged()
    }

}