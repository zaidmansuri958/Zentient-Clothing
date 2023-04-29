package com.example.apnamall.presentation.product_detail

import android.animation.ValueAnimator
import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.apnamall.R
import com.example.apnamall.data.model.Size
import com.example.apnamall.data.model.like.LikeRequest
import com.example.apnamall.data.model.cart.CartRequest
import com.example.apnamall.data.model.product.Product
import com.example.apnamall.data.model.product.ProductItem
import com.example.apnamall.data.util.Resource
import com.example.apnamall.databinding.FragmentProductDetailBinding
import com.example.apnamall.presentation.adapter.product.ProductViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class ProductDetailFragment : Fragment() {

    @Inject
    lateinit var productDetailViewModelFactory: ProductDetailViewModelFactory

    @Inject
    lateinit var productViewPagerAdapter: ProductViewPagerAdapter
    lateinit var viewModel: ProductDetailViewModel
    private lateinit var binding: FragmentProductDetailBinding
    private var productSize: String? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)
                .setDuration(1000)
        return inflater.inflate(R.layout.fragment_product_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProductDetailBinding.bind(view)
        viewModel = ViewModelProvider(
            this,
            productDetailViewModelFactory
        ).get(ProductDetailViewModel::class.java)

        val args: ProductDetailFragmentArgs by navArgs()
        val product = args.selectedItem

        binding.nameTv.text = product.productName
        binding.descTv.text = product.productDesc
        binding.firstS.text = product.Size!!.one
        binding.secondS.text = product.Size!!.two
        binding.thirdS.text = product.Size!!.three
        binding.fourthS.text = product.Size!!.four
        product.productPrice?.let { setPriceAnim(it) }
        binding.productViewpager.apply {
            adapter = productViewPagerAdapter
        }
        binding.productViewpager.transitionName = product._id
        binding.nameTv.transitionName = product._id + "name"
        setOnCheckedChangeListener()
        val list =
            mutableListOf(product.productImg1, product.productImg2, product.productImg3)
        productViewPagerAdapter.differ.submitList(list)
        showCounter()

        setLikeBtn(product._id!!)

        binding.increase.setOnClickListener {
            viewModel.increaseCounter()
            showCounter()
            binding.priceTv.text = "$ " +
                    (Integer.parseInt(product.productPrice.toString()) * viewModel.counter).toString()
        }

        binding.decrease.setOnClickListener {
            if (viewModel.counter == 1) {
                Toast.makeText(activity, "Quantity should be more than one", Toast.LENGTH_SHORT)
                    .show()
            } else {
                viewModel.decreaseCounter()
                binding.priceTv.text = "$ " +
                        (Integer.parseInt(product.productPrice.toString()) * viewModel.counter).toString()
                showCounter()
            }
        }

        binding.like.setOnClickListener {
            setLikeClick(product)
        }

        binding.orderBtn.setOnClickListener {
            if (productSize.isNullOrEmpty()) {
                Toast.makeText(activity, "Please select Product Size", Toast.LENGTH_LONG).show()
            } else {
                viewModel.submitOrder(
                    CartRequest(
                        product.productDesc,
                        product.productID,
                        product.productImg1,
                        product.productImg2,
                        product.productImg3,
                        product.productName,
                        (Integer.parseInt(product.productPrice.toString()) * viewModel.counter).toString(),
                        viewModel.counter.toString(),
                        productSize
                    )
                )

                viewModel.submitOrder.observe(viewLifecycleOwner, Observer { response ->
                    when (response) {
                        is Resource.Success -> {
                            response.data?.let {
                                Toast.makeText(
                                    activity,
                                    response.data.toString(),
                                    Toast.LENGTH_LONG
                                )
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
    }

    private fun setOnCheckedChangeListener() {
        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.first_S ->
                    productSize = binding.firstS.text.toString()
                R.id.second_s ->
                    productSize = binding.secondS.text.toString()
                R.id.third_s ->
                    productSize = binding.thirdS.text.toString()
                R.id.fourth_s ->
                    productSize = binding.fourthS.text.toString()
            }
        }
    }

    private fun showCounter() {
        binding.counter.text = viewModel.counter.toString()
    }

    private fun setPriceAnim(price: String) {
        val valueAnimator = ValueAnimator.ofInt(0, Integer.parseInt(price))
        valueAnimator.addUpdateListener {
            binding.priceTv.text = "$ " + valueAnimator.animatedValue.toString()
        }
        valueAnimator.setDuration(1500)
        valueAnimator.start()
    }

    private fun setLikeBtn(productId: String) {
        GlobalScope.launch(Dispatchers.Main) {
            viewModel.chekLikedOrNot(productId)
            if (viewModel.isExistOrNot == true) {
                binding.like.setImageResource(R.drawable.liked)
            } else {
                binding.like.setImageResource(R.drawable.like)
            }
        }
    }

    private fun setLikeClick(product: ProductItem) {
        GlobalScope.launch(Dispatchers.Main) {
            viewModel.chekLikedOrNot(product._id!!)
            if (viewModel.isExistOrNot != true) {
                viewModel.submitLike(
                    LikeRequest(
                        product._id!!,
                        product.productDesc,
                        product.productID,
                        product.productImg1,
                        product.productImg2,
                        product.productImg3,
                        product.productName,
                        product.productPrice,
                        viewModel.counter.toString(),
                        "7"
                    )
                )
                binding.like.setImageResource(R.drawable.liked)
            } else {
                viewModel.removeLike(product._id!!)
                binding.like.setImageResource(R.drawable.like)
            }
        }

    }
}