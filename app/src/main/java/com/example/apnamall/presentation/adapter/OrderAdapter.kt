package com.example.apnamall.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.transition.AutoTransition
import androidx.transition.TransitionManager
import com.bumptech.glide.Glide
import com.example.apnamall.data.model.cart.CartResponseItem
import com.example.apnamall.data.model.order.OrderResponseItem
import com.example.apnamall.databinding.OrderCardBinding
import com.kofigyan.stateprogressbar.StateProgressBar


class OrderAdapter : RecyclerView.Adapter<OrderViewHolder>() {
    private val description: Array<String> =
        arrayOf("Pick Up", "On Process", "On Delivery", "Delivered")

    private val callback = object : DiffUtil.ItemCallback<OrderResponseItem>() {
        override fun areItemsTheSame(
            oldItem: OrderResponseItem,
            newItem: OrderResponseItem
        ): Boolean {
            return oldItem.productID == newItem.productID
        }

        override fun areContentsTheSame(
            oldItem: OrderResponseItem,
            newItem: OrderResponseItem
        ): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = OrderCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OrderViewHolder(view)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val data = differ.currentList[position]
        holder.binding.orderProductName.text = data.productName
        holder.binding.orderProductDesc.text = data.productDesc
        holder.binding.orderProductSize.text = data.size
        holder.binding.orderProductPrice.text = "$ " + data.productPrice
        holder.binding.orderProductQuantity.text = data.quantity
        Glide.with(holder.binding.orderProductImg).load(data.productImg1)
            .into(holder.binding.orderProductImg)

//        set the delivery status

        when (data.status) {
            "Pick Up" -> {
                holder.binding.yourStateProgressBarId.setCurrentStateNumber(
                    StateProgressBar.StateNumber.TWO
                )
                holder.binding.btnCancelOrder.visibility = View.VISIBLE
            }
            "On Process" -> {
                holder.binding.yourStateProgressBarId.setCurrentStateNumber(
                    StateProgressBar.StateNumber.THREE
                )
            }
            "On Delivery" -> {
                holder.binding.yourStateProgressBarId.setCurrentStateNumber(
                    StateProgressBar.StateNumber.FOUR
                )
            }
            "Delivered" -> {
                holder.binding.yourStateProgressBarId.setAllStatesCompleted(true)
            }
        }

        holder.binding.arrowButton.setOnClickListener {
            if (holder.binding.hiddenView.visibility === View.VISIBLE) {
                TransitionManager.beginDelayedTransition(holder.binding.root, AutoTransition())
                holder.binding.hiddenView.visibility = View.GONE
                holder.binding.arrowButton.rotation = 90F
            } else {
                TransitionManager.beginDelayedTransition(holder.binding.root, AutoTransition())
                holder.binding.hiddenView.visibility = View.VISIBLE
                holder.binding.arrowButton.rotation = -90F
            }
        }
        holder.binding.yourStateProgressBarId.setStateDescriptionData(description)
        holder.binding.btnCancelOrder.setOnClickListener {
            onItemClickListener?.let {
                it(data._id)
            }
        }
    }

    private var onItemClickListener: ((String) -> Unit)? = null
    fun setOnItemClickListner(listner: (String) -> Unit) {
        onItemClickListener = listner
    }
}

class OrderViewHolder(val binding: OrderCardBinding) : ViewHolder(binding.root)