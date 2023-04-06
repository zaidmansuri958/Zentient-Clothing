package com.example.apnamall.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.apnamall.data.model.Size
import com.example.apnamall.data.model.category.CategoryItem
import com.example.apnamall.data.model.like.LikeRequest
import com.example.apnamall.data.model.like.LikeResponseItem
import com.example.apnamall.data.model.product.ProductItem
import com.example.apnamall.databinding.LikeCardBinding

class LikeAdapter : RecyclerView.Adapter<likeViewHolder>() {

    private val callback = object : DiffUtil.ItemCallback<LikeRequest>() {
        override fun areItemsTheSame(
            oldItem: LikeRequest,
            newItem: LikeRequest
        ): Boolean {
            return oldItem.productID == newItem.productID
        }

        override fun areContentsTheSame(
            oldItem: LikeRequest,
            newItem: LikeRequest
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
        holder.binding.likeProductPrice.text = "$ " + likeItem.productPrice
        Glide.with(holder.binding.likeProductImg).load(likeItem.productImg1)
            .into(holder.binding.likeProductImg)

        holder.binding.likedImg.setOnClickListener {
            onLikeClickListener?.let {
                it(likeItem._id)
            }
        }

        holder.itemView.setOnClickListener {
            onItemClickListener?.let {
                it(
                    ProductItem(
                        Size(likeItem.size, likeItem.size, likeItem.size, likeItem.size),
                        likeItem._id,
                        likeItem.productDesc,
                        likeItem.productID,
                        likeItem.productImg1,
                        likeItem.productImg2,
                        likeItem.productImg3,
                        likeItem.productName,
                        likeItem.productPrice,
                        "0"
                    )
                )
            }
        }
    }

    private var onLikeClickListener: ((String) -> Unit)? = null
    fun setOnLikeClickListner(listner: (String) -> Unit) {
        onLikeClickListener = listner
    }

    private var onItemClickListener: ((ProductItem) -> Unit)? = null
    fun setOnItemClickListner(listner: (ProductItem) -> Unit) {
        onItemClickListener = listner
    }

}


class likeViewHolder(val binding: LikeCardBinding) : ViewHolder(binding.root)