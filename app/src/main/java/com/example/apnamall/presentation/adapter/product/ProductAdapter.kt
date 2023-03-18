package com.example.apnamall.presentation.adapter.product

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apnamall.data.model.product.ProductItem
import com.example.apnamall.databinding.ProductCardBinding
import org.w3c.dom.Text

class ProductAdapter : RecyclerView.Adapter<ViewHolder>() {
    private val callback = object : DiffUtil.ItemCallback<ProductItem>() {
        override fun areItemsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean {
            return oldItem._id == newItem._id
        }

        override fun areContentsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ProductCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val productList = differ.currentList[position]
        holder.binding.name.text = productList.productName
        holder.binding.price.text = "$ " + productList.productPrice
        holder.binding.image.transitionName=productList._id.toString()
        holder.binding.name.transitionName=productList._id+"name"
        holder.binding.price.transitionName=productList._id+"price"
        Glide.with(holder.binding.image).load(productList.productImg1).into(holder.binding.image)

        holder.itemView.setOnClickListener {
            onItemClickListener?.let {
                it(productList, holder.binding.image, holder.binding.name, holder.binding.price)
            }
        }
    }

    private var onItemClickListener: ((ProductItem, ImageView, TextView, TextView) -> Unit)? = null
    fun setOnItemClickListner(listner: (ProductItem, ImageView, TextView, TextView) -> Unit) {
        onItemClickListener = listner
    }
}

class ViewHolder(val binding: ProductCardBinding) : RecyclerView.ViewHolder(binding.root)