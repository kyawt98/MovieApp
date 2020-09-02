package com.kyawt.shimmertesting.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kyawt.shimmertesting.R
import com.kyawt.shimmertesting.service.model.movie.MovieResult
import com.kyawt.shimmertesting.view.exts.viewBinding
import com.kyawt.shimmertesting.view.viewholder.UpcomingViewHolder

class UpcomingAdapter(var upcomingList: List<MovieResult> = emptyList()) : RecyclerView.Adapter<UpcomingViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingViewHolder {
        return UpcomingViewHolder(parent.context.viewBinding(R.layout.item_movie,parent))
    }

    override fun onBindViewHolder(holder: UpcomingViewHolder, position: Int) {
        holder.bind(upcomingList[position])
    }

    override fun getItemCount(): Int = upcomingList.size

    fun updateList(upcomingList: List<MovieResult>){
        this.upcomingList = upcomingList
        notifyDataSetChanged()
    }
}