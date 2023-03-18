package com.example.apnamall.presentation.adapter.home_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apnamall.data.model.product.ProductItem
import com.example.apnamall.databinding.BestSellerCardBinding


class BestSellerAdapter : RecyclerView.Adapter<bestSellerViewHolder>() {
    private val callback = object : DiffUtil.ItemCallback<ProductItem>() {
        override fun areItemsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean {
            return oldItem._id == newItem._id
        }

        override fun areContentsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, callback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bestSellerViewHolder {
        val view = BestSellerCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return bestSellerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: bestSellerViewHolder, position: Int) {
        val bestSellerList = differ.currentList[position]
        holder.binding.name.text = bestSellerList.productName
        holder.binding.price.text = "$ "+bestSellerList.productPrice
        Glide.with(holder.binding.image).load(bestSellerList.productImg1).into(holder.binding.image)
        holder.itemView.setOnClickListener {
            onItemClickListener?.let {
                it(bestSellerList)
            }
        }
    }

    private var onItemClickListener: ((ProductItem) -> Unit)? = null
    fun setOnItemClickListner(listner: (ProductItem) -> Unit) {
        onItemClickListener = listner
    }

}

class bestSellerViewHolder(val binding: BestSellerCardBinding) :
    RecyclerView.ViewHolder(binding.root)