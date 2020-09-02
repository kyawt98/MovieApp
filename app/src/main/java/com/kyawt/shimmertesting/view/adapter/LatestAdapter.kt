package com.kyawt.shimmertesting.view.adapter
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kyawt.shimmertesting.R
import com.kyawt.shimmertesting.service.model.movie.MovieResult
import com.kyawt.shimmertesting.view.exts.viewBinding
import com.kyawt.shimmertesting.view.viewholder.LatestViewHolder

class LatestAdapter(var latestList: List<MovieResult> = emptyList()) :
    RecyclerView.Adapter<LatestViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestViewHolder {
        return LatestViewHolder(parent.context.viewBinding(R.layout.item_movie, parent))
    }

    override fun onBindViewHolder(holder: LatestViewHolder, position: Int) {
        holder.bind(latestList[position])
    }

    override fun getItemCount(): Int = latestList.size

    fun updateList(latestList: List<MovieResult>) {
        this.latestList = latestList
        notifyDataSetChanged()
    }

}