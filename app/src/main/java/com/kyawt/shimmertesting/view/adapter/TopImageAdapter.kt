package com.kyawt.shimmertesting.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kyawt.shimmertesting.R
import com.kyawt.shimmertesting.service.model.movie.MovieResult
import com.kyawt.shimmertesting.view.exts.viewBinding
import com.kyawt.shimmertesting.view.viewholder.TopImageViewHolder

class TopImageAdapter (var topList: List<MovieResult> = ArrayList()) : RecyclerView.Adapter<TopImageViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopImageViewHolder {
        return TopImageViewHolder(parent.context.viewBinding(R.layout.item_top,parent))
    }

    override fun onBindViewHolder(holder: TopImageViewHolder, position: Int) {
        holder.bind(topList[position])
    }

    override fun getItemCount(): Int = topList.size

    fun updateList(topList: List<MovieResult>){
        this.topList = topList
        notifyDataSetChanged()
    }

}