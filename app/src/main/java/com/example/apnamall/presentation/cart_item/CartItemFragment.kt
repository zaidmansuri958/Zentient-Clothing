package com.example.apnamall.presentation.cart_item

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.apnamall.R
import com.example.apnamall.data.util.Resource
import com.example.apnamall.databinding.FragmentCartItemBinding
import com.example.apnamall.presentation.product_detail.ProductDetailFragmentArgs
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CartItemFragment : Fragment() {
    @Inject
    lateinit var cartItemViewModelFactory: CartItemViewModelFactory
    private lateinit var viewModel: CartItemViewModel
    private lateinit var binding: FragmentCartItemBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCartItemBinding.bind(view)
        viewModel =
            ViewModelProvider(this, cartItemViewModelFactory).get(CartItemViewModel::class.java)

        val args:CartItemFragmentArgs by navArgs()
        val product = args.selectedCartItem
        Glide.with(binding.productImg).load(product.productImg1).into(binding.productImg)
        binding.nameTv.text = product.productName
        binding.descTv.text = product.productDesc
        binding.priceTv.text = "$ "+product.productPrice
        binding.sizeTv.text="Size :"+product.size
        binding.quantityTv.text="Quantity :"+product.quantity
        binding.removeBtn.setOnClickListener{
            viewModel.deleteOrder(product._id)
        }

        viewModel.deleteOrder.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    response.data?.let {
                        Toast.makeText(activity, response.data.toString(), Toast.LENGTH_LONG)
                            .show()
                    }
                }
                is Resource.Loading -> {
                    Toast.makeText(activity, "Loading", Toast.LENGTH_SHORT).show()
                }
                is Resource.Error -> {
                    Toast.makeText(activity, response.message.toString(), Toast.LENGTH_LONG)
                        .show()
                }
            }
        })

    }
}