package com.example.apnamall.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.apnamall.data.model.product.ProductItem
import com.example.apnamall.data.model.video.VideoItem
import com.example.apnamall.databinding.VideoCardBinding

class VideoAdapter : RecyclerView.Adapter<VideoViewHolder>() {
    private val callback = object : DiffUtil.ItemCallback<VideoItem>() {
        override fun areItemsTheSame(
            oldItem: VideoItem,
            newItem: VideoItem
        ): Boolean {
            return oldItem._id == newItem._id
        }

        override fun areContentsTheSame(
            oldItem: VideoItem,
            newItem: VideoItem
        ): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, callback)


    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val video = differ.currentList[position]
        val productItem = ProductItem(
            video.Size,
            video._id,
            video.productDesc,
            video.productID,
            video.productImg1,
            video.productImg2,
            video.productImg3,
            video.productName,
            video.productPrice,
            video.productDiscount
        )
        holder.binding.videoName.text = video.productName
        holder.binding.videoDesc.text = video.productDesc
        holder.binding.videoView.setVideoPath(video.url)
        holder.binding.videoView.setOnPreparedListener {
            holder.binding.progressBar.isVisible = false
            it.start()
        }

        holder.binding.videoView.setOnCompletionListener {
            it.start()
        }


        holder.binding.videoBtn.setOnClickListener {
            onItemClickListener?.let {
                it(productItem)
            }
        }
    }

    private var onItemClickListener: ((ProductItem) -> Unit)? = null
    fun setOnItemClickListner(listner: (ProductItem) -> Unit) {
        onItemClickListener = listner
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = VideoCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VideoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


}

class VideoViewHolder(val binding: VideoCardBinding) : RecyclerView.ViewHolder(binding.root)