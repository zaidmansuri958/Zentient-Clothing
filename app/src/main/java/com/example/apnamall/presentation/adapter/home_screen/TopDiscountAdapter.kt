package com.example.apnamall.presentation.adapter.home_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apnamall.data.model.product.ProductItem
import com.example.apnamall.databinding.BestSellerCardBinding


class TopDiscountAdapter : RecyclerView.Adapter<DiscountViewHolder>() {

    private val callback = object : DiffUtil.ItemCallback<ProductItem>() {
        override fun areItemsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean {
            return oldItem._id == newItem._id
        }

        override fun areContentsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscountViewHolder {
        val view = BestSellerCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DiscountViewHolder(view)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: DiscountViewHolder, position: Int) {
        val topDiscountList = differ.currentList[position]
        holder.bestSellerCardBinding.name.text = topDiscountList.productName
        holder.bestSellerCardBinding.price.text = topDiscountList.productDiscount
        Glide.with(holder.bestSellerCardBinding.image).load(topDiscountList.productImg1)
            .into(holder.bestSellerCardBinding.image)

        holder.itemView.setOnClickListener {
            onItemClickListener?.let {
                it(topDiscountList)
            }
        }
    }

    private var onItemClickListener: ((ProductItem) -> Unit)? = null
    fun setOnItemClickListner(listner: (ProductItem) -> Unit) {
        onItemClickListener = listner
    }
}

class DiscountViewHolder(val bestSellerCardBinding: BestSellerCardBinding) :
    RecyclerView.ViewHolder(bestSellerCardBinding.root)