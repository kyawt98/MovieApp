package com.kyawt.shimmertesting.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kyawt.shimmertesting.R
import com.kyawt.shimmertesting.service.model.detail.MovieDetail
import com.kyawt.shimmertesting.service.model.movie.MovieResult
import com.kyawt.shimmertesting.view.exts.viewBinding
import com.kyawt.shimmertesting.view.viewholder.NowPlayingViewHolder

class NowPlayingAdapter(private var mClickListener: NowPlayingViewHolder.ClickListener,
    var nowPlayingList: List<MovieResult> = emptyList()) :
    RecyclerView.Adapter<NowPlayingViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NowPlayingViewHolder {
        return NowPlayingViewHolder(parent.context.viewBinding(R.layout.item_movie, parent),mClickListener)
    }

    override fun onBindViewHolder(holder: NowPlayingViewHolder, position: Int) {
        holder.bind(nowPlayingList[position])
    }

    override fun getItemCount(): Int = nowPlayingList.size

    fun updateList(nowPlayingList: List<MovieResult>){
        this.nowPlayingList = nowPlayingList
        notifyDataSetChanged()
    }

}