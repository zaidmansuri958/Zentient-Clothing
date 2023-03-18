package com.example.apnamall.presentation.adapter.product

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.example.apnamall.data.model.product.ProductItem
import com.example.apnamall.databinding.ProductPagerCardBinding

class ProductViewPagerAdapter:Adapter<ViewPagerHolder>() {

    private val callback = object : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem== newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder {
        val view=ProductPagerCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewPagerHolder(view)
    }

    override fun getItemCount(): Int {
       return  differ.currentList.size
    }

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        val image=differ.currentList[position]
        Glide.with(holder.binding.productImg).load(image).into(holder.binding.productImg)
    }
}

class ViewPagerHolder(val binding: ProductPagerCardBinding) :RecyclerView.ViewHolder(binding.root)