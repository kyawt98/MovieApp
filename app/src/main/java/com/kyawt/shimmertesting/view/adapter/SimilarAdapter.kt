package com.kyawt.shimmertesting.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kyawt.shimmertesting.R
import com.kyawt.shimmertesting.service.model.movie.MovieResult
import com.kyawt.shimmertesting.view.exts.viewBinding
import com.kyawt.shimmertesting.view.viewholder.SimilarViewHolder

class SimilarAdapter (private val mClickListener: SimilarViewHolder.OnClickListener ,
                      var similarList: List<MovieResult> = emptyList()) : RecyclerView.Adapter<SimilarViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimilarViewHolder {
        return SimilarViewHolder(parent.context.viewBinding(R.layout.item_movie, parent), mClickListener)
    }

    override fun onBindViewHolder(holder: SimilarViewHolder, position: Int) {
        holder.bind(similarList[position])
    }

    override fun getItemCount(): Int = similarList.size

    fun updateList(similarList: List<MovieResult>){
        this.similarList = similarList
        notifyDataSetChanged()
    }
}