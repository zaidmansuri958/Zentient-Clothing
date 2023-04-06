package com.example.apnamall.presentation.cart

import android.animation.ValueAnimator
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apnamall.MainActivity
import com.example.apnamall.R
import com.example.apnamall.data.util.Resource
import com.example.apnamall.databinding.FragmentCartBinding
import com.example.apnamall.presentation.adapter.CartAdapter
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import dagger.hilt.android.AndroidEntryPoint
import org.json.JSONException
import org.json.JSONObject
import javax.inject.Inject

@AndroidEntryPoint
class CartFragment : Fragment() {
    @Inject
    lateinit var cartViewModelFactory: CartViewModelFactory

    @Inject
    lateinit var cartAdapter: CartAdapter

    private lateinit var viewModel: CartViewModel
    private lateinit var binding: FragmentCartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCartBinding.bind(view)
        viewModel = ViewModelProvider(this, cartViewModelFactory).get(CartViewModel::class.java)
        viewModel.getCartItem()

        provideObserver()

        cartAdapter.setOnItemClickListner {
            val bundle = Bundle().apply {
                putSerializable("selected_cart_item", it)
            }
            findNavController().navigate(R.id.action_cartFragment_to_cartItemFragment, bundle)
        }

        binding.cartRecycle.apply {
            adapter = cartAdapter
            layoutManager = LinearLayoutManager(activity)
        }

        binding.orderBtn.setOnClickListener {
            val bundle = Bundle().apply {
                putSerializable("price", ((cartAdapter.getGrandTotal()) * 100).toString())
            }
            findNavController().navigate(R.id.action_cartFragment_to_bottomSheetFragment, bundle)
        }
    }

    private fun setPriceAnim() {
        val valueAnimator = ValueAnimator.ofInt(0, cartAdapter.getGrandTotal())
        valueAnimator.addUpdateListener {
            binding.priceTv.text = "$ " + valueAnimator.animatedValue.toString()
        }
        valueAnimator.setDuration(1000)
        valueAnimator.start()
    }
    private fun provideObserver() {
        viewModel.cartItem.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    binding.shimmerFrameLayout.stopShimmer()
                    binding.shimmer.visibility = View.GONE
                    binding.ll.visibility = View.VISIBLE
                    response.data?.let {
                        cartAdapter.differ.submitList(it.toList())
                        setPriceAnim()
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