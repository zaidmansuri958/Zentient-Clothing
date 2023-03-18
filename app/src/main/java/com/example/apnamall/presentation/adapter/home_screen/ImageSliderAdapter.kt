package com.example.apnamall.presentation.adapter.home_screen


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.apnamall.data.model.product.ProductItem
import com.example.apnamall.data.model.slider.SliderItem
import com.example.apnamall.databinding.SliderCardBinding


class ImageSliderAdapter() : RecyclerView.Adapter<SliderViewHolder>() {
    private val callback = object : DiffUtil.ItemCallback<SliderItem>() {
        override fun areItemsTheSame(oldItem: SliderItem, newItem: SliderItem): Boolean {
            return oldItem._id == newItem._id
        }

        override fun areContentsTheSame(oldItem: SliderItem, newItem: SliderItem): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, callback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        val view = SliderCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SliderViewHolder(view)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        val sliderImage = differ.currentList[position]
        holder.binding.sliderTxt.text = sliderImage.productDesc
        holder.binding.sliderBtn.text = sliderImage.btnText
        Glide.with(holder.binding.sliderImg).load(sliderImage.productImg1)
            .into(holder.binding.sliderImg)
    }
}

class SliderViewHolder(val binding: SliderCardBinding) : RecyclerView.ViewHolder(binding.root)
