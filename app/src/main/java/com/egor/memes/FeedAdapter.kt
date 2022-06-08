package com.egor.memes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.egor.memes.data.entity.MemeEntity
import com.egor.memes.databinding.LayoutMemeContainerBinding

class FeedAdapter(
    private val feedList: List<MemeEntity>
) : RecyclerView.Adapter<FeedAdapter.ViewHolder>() {

    inner class ViewHolder(
        private val binding: LayoutMemeContainerBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(memeEntity: MemeEntity) {
            binding.data = memeEntity
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LayoutMemeContainerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(feedList[position])
    }

    override fun getItemCount(): Int {
        return feedList.size
    }
}