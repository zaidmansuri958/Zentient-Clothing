package com.example.apnamall.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apnamall.data.model.cart.CartResponse
import com.example.apnamall.data.model.cart.CartResponseItem
import com.example.apnamall.databinding.CartCardBinding

class CartAdapter : RecyclerView.Adapter<CartViewHolder>() {
    private val callback = object : DiffUtil.ItemCallback<CartResponseItem>() {
        override fun areItemsTheSame(
            oldItem: CartResponseItem,
            newItem: CartResponseItem
        ): Boolean {
            return oldItem._id == newItem._id
        }

        override fun areContentsTheSame(
            oldItem: CartResponseItem,
            newItem: CartResponseItem
        ): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, callback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = CartCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(view)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val cartItem = differ.currentList[position]
        holder.binding.cartProductName.text = cartItem.productName
        holder.binding.cartProductDesc.text = cartItem.productDesc
        holder.binding.cartProductSize.text = "Size :" + cartItem.size
        holder.binding.cartProductQuantity.text = cartItem.quantity
        holder.binding.cartProductPrice.text ="$ "+cartItem.productPrice
        Glide.with(holder.itemView).load(cartItem.productImg1).into(holder.binding.cartProductImg)
        holder.itemView.setOnClickListener {
            onItemClickListener?.let {
                it(cartItem)
            }
        }
    }

    private var onItemClickListener: ((CartResponseItem) -> Unit)? = null
    fun setOnItemClickListner(listner: (CartResponseItem) -> Unit) {
        onItemClickListener = listner
    }

    fun getGrandTotal(): Int {
        var totalPrice = 0
        for (i in 0 until differ.currentList.size) {
            totalPrice += Integer.parseInt(differ.currentList[i].productPrice)
        }
        return totalPrice
    }
}

class CartViewHolder(val binding: CartCardBinding) : RecyclerView.ViewHolder(binding.root)