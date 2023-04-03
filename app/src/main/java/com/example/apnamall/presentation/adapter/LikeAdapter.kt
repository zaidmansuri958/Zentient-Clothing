package com.example.apnamall.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.apnamall.data.model.like.LikeResponseItem
import com.example.apnamall.databinding.LikeCardBinding

class LikeAdapter : RecyclerView.Adapter<likeViewHolder>() {

    private val callback = object : DiffUtil.ItemCallback<LikeResponseItem>() {
        override fun areItemsTheSame(
            oldItem: LikeResponseItem,
            newItem: LikeResponseItem
        ): Boolean {
            return oldItem._id == newItem._id
        }

        override fun areContentsTheSame(
            oldItem: LikeResponseItem,
            newItem: LikeResponseItem
        ): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): likeViewHolder {
        val view = LikeCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return likeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: likeViewHolder, position: Int) {
        val likeItem = differ.currentList[position]
        holder.binding.likeProductDesc.text = likeItem.productDesc
        holder.binding.likeProductName.text = likeItem.productName
        holder.binding.likeProductPrice.text = likeItem.productPrice
        Glide.with(holder.binding.likeProductImg).load(likeItem.productImg1)
            .into(holder.binding.likeProductImg)
    }
}

class likeViewHolder(val binding: LikeCardBinding) : ViewHolder(binding.root)