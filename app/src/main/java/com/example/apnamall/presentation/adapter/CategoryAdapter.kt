package com.example.apnamall.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.apnamall.data.model.category.CategoryItem
import com.example.apnamall.databinding.CategoryCardBinding

class CategoryAdapter : RecyclerView.Adapter<CategoryViewHolder>() {
    val callback = object : DiffUtil.ItemCallback<CategoryItem>() {
        override fun areItemsTheSame(oldItem: CategoryItem, newItem: CategoryItem): Boolean {
            return oldItem._id == newItem._id
        }

        override fun areContentsTheSame(oldItem: CategoryItem, newItem: CategoryItem): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, callback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = CategoryCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val categoryItems = differ.currentList[position]
        holder.binding.categoryName.text = categoryItems.categoryName
        Glide.with(holder.binding.categoryImg).load(categoryItems.categoryImage)
            .into(holder.binding.categoryImg)

        holder.itemView.setOnClickListener {
            onItemClickListener?.let {
                it(categoryItems)
            }
        }
    }

    private var onItemClickListener: ((CategoryItem) -> Unit)? = null
    fun setOnItemClickListner(listner: (CategoryItem) -> Unit) {
        onItemClickListener = listner
    }
}

class CategoryViewHolder(val binding: CategoryCardBinding) : ViewHolder(binding.root)