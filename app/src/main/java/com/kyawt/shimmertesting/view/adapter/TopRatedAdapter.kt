package com.kyawt.shimmertesting.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kyawt.shimmertesting.R
import com.kyawt.shimmertesting.service.model.movie.MovieResult
import com.kyawt.shimmertesting.view.exts.viewBinding
import com.kyawt.shimmertesting.view.viewholder.TopRatedViewHolder

class TopRatedAdapter(private var mClickListener: TopRatedViewHolder.ClickListener,
    var topRatedList: List<MovieResult> = emptyList()) : RecyclerView.Adapter<TopRatedViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedViewHolder {
        return TopRatedViewHolder(parent.context.viewBinding(R.layout.item_movie,parent), mClickListener)
    }

    override fun onBindViewHolder(holder: TopRatedViewHolder, position: Int) {
        holder.bind(topRatedList[position])
    }

    override fun getItemCount(): Int = topRatedList.size

    fun updateList(topRatedList: List<MovieResult>){
        this.topRatedList = topRatedList
        notifyDataSetChanged()
    }
}