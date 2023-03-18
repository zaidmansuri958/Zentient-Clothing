package com.example.apnamall.presentation.adapter.home_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apnamall.data.model.product.ProductItem
import com.example.apnamall.databinding.ProductCardBinding

class MenTopItemsAdapter:RecyclerView.Adapter<MenTopItemsViewHolder>() {
    private val callback = object : DiffUtil.ItemCallback<ProductItem>() {
        override fun areItemsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean {
            return oldItem._id == newItem._id
        }

        override fun areContentsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean {
            return oldItem==newItem
        }
    }
    val differ= AsyncListDiffer(this,callback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenTopItemsViewHolder {
       val view=ProductCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MenTopItemsViewHolder(view)
    }

    override fun getItemCount(): Int {
      return differ.currentList.size
    }

    override fun onBindViewHolder(holder: MenTopItemsViewHolder, position: Int) {
        val menTopList=differ.currentList[position]
        holder.binding.name.text =  menTopList.productName
        holder.binding.price.text = "$ "+menTopList.productPrice
        Glide.with(holder.binding.image).load( menTopList.productImg1).into(holder.binding.image)

        holder.itemView.setOnClickListener {
            onItemClickListener?.let {
                it(menTopList)
            }
        }
    }

    private var onItemClickListener: ((ProductItem) -> Unit)? = null
    fun setOnItemClickListner(listner: (ProductItem) -> Unit) {
        onItemClickListener = listner
    }
}

class MenTopItemsViewHolder(val binding:ProductCardBinding):RecyclerView.ViewHolder(binding.root)