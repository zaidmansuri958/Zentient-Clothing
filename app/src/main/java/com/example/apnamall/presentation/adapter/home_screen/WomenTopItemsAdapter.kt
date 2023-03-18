package com.example.apnamall.presentation.adapter.home_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.apnamall.data.model.product.ProductItem
import com.example.apnamall.databinding.ProductCardBinding

class WomenTopItemsAdapter : RecyclerView.Adapter<WomenTopViewHolder>() {
    private val callback = object : DiffUtil.ItemCallback<ProductItem>() {
        override fun areItemsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean {
            return oldItem._id == newItem._id
        }

        override fun areContentsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WomenTopViewHolder {
        val view = ProductCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WomenTopViewHolder(view)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: WomenTopViewHolder, position: Int) {
        val topWomenItems = differ.currentList[position]
        holder.binding.name.text = topWomenItems.productName
        holder.binding.price.text = "$ " + topWomenItems.productPrice
        Glide.with(holder.binding.image).load(topWomenItems.productImg1).into(holder.binding.image)
        holder.itemView.setOnClickListener {
            onItemClickListener?.let {
                it(topWomenItems)
            }
        }
    }

    private var onItemClickListener: ((ProductItem) -> Unit)? = null
    fun setOnItemClickListner(listner: (ProductItem) -> Unit) {
        onItemClickListener = listner
    }
}

class WomenTopViewHolder(val binding: ProductCardBinding) : ViewHolder(binding.root)