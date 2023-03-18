package com.example.apnamall.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apnamall.R
import com.example.apnamall.data.model.product.Product
import com.example.apnamall.data.model.product.ProductItem
import com.example.apnamall.data.model.slider.Slider
import com.example.apnamall.data.util.Resource
import com.example.apnamall.databinding.FragmentHomeBinding
import com.example.apnamall.presentation.adapter.home_screen.*
import com.facebook.shimmer.ShimmerFrameLayout
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class HomeFragment : Fragment() {
    @Inject
    lateinit var homeViewModelFactory: HomeViewModelFactory

    @Inject
    lateinit var bestSellerAdapter: BestSellerAdapter

    @Inject
    lateinit var menTopAdapter: MenTopItemsAdapter

    @Inject
    lateinit var sliderAdapter: ImageSliderAdapter

    @Inject
    lateinit var topDiscountAdapter: TopDiscountAdapter

    @Inject
    lateinit var topWomenAdapter: WomenTopItemsAdapter

    private lateinit var homeBinding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeBinding = FragmentHomeBinding.bind(view)
        viewModel = ViewModelProvider(this, homeViewModelFactory).get(HomeViewModel::class.java)

        /******* SET RECYCLERVIEW OF BEST SELLLER ITEMS *******/
        homeBinding.homeBestsellerRecycle.apply {
            adapter = bestSellerAdapter
            layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        }
        /******* SET RECYCLERVIEW OF TOP MALE ITEMS *******/
        homeBinding.homeMaleRecycle.apply {
            adapter = menTopAdapter
            layoutManager = GridLayoutManager(activity, 2)
        }
        /******* SET RECYCLERVIEW OF TOP DISCOUNT ITEMS *******/
        homeBinding.homeDiscountRecycle.apply {
            adapter = topDiscountAdapter
            layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        }
        /******* SET RECYCLERVIEW OF TOP FEMALE ITEMS *******/
        homeBinding.homeFemaleRecycle.apply {
            adapter = topWomenAdapter
            layoutManager = GridLayoutManager(activity, 2)
        }
        /******* SET RECYCLERVIEW OF SLIDER ITEMS *******/
        homeBinding.homeViewpager.apply {
            adapter = sliderAdapter
        }

        /******* SET CLICK LISTENER ON RECYCLERVIEW ITEMS *******/
        bestSellerAdapter.setOnItemClickListner {
            setOnclickListner(it)
        }
        menTopAdapter.setOnItemClickListner {
            setOnclickListner(it)
        }
        topWomenAdapter.setOnItemClickListner {
            setOnclickListner(it)
        }
        topDiscountAdapter.setOnItemClickListner {
            setOnclickListner(it)
        }

        /******* GET ITEMS FROM THE VIEWMODEL AND PROVIDE OBSERVERS *******/
        viewModel.getSliders()
        provideSliderObserver(sliderAdapter, viewModel.slider)
        viewModel.getBestSeller()
        provideBestSellerObserver(bestSellerAdapter, viewModel.bestSellers)
        viewModel.getTopMale()
        provideMaleTopObserver(menTopAdapter, viewModel.topMale)
        viewModel.getTopDiscount()
        provideTopDiscountObserver(topDiscountAdapter, viewModel.topDiscount)
        viewModel.getTopFemale()
        provideTopFemaleObserver(topWomenAdapter, viewModel.topFemale)
    }

    private fun provideSliderObserver(
        sliderAdapter: ImageSliderAdapter,
        slider: MutableLiveData<Resource<Slider>>
    ) {
        slider.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    response.data?.let {
                        sliderAdapter.differ.submitList(it.toList())
                    }
                }
                is Resource.Loading -> {
                    Log.d("MYTAG", "Error")
                }
                is Resource.Error -> {
                    Log.d("MYTAG", "Loading")
                }
            }
        }
    }

    private fun provideTopFemaleObserver(
        topWomenAdapter: WomenTopItemsAdapter,
        topFemale: MutableLiveData<Resource<Product>>
    ) {
        topFemale.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    homeBinding.womenTop.visibility = View.VISIBLE
                    response.data?.let {
                        topWomenAdapter.differ.submitList(it.toList())
                    }
                }
                is Resource.Loading -> {
                    Log.d("MYTAG", "Error")
                }
                is Resource.Error -> {
                    Log.d("MYTAG", "Loading")
                }
            }
        }
    }

    private fun provideTopDiscountObserver(
        topDiscountAdapter: TopDiscountAdapter,
        topDiscount: MutableLiveData<Resource<Product>>
    ) {
        topDiscount.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    homeBinding.topDiscount.visibility = View.VISIBLE
                    homeBinding.shimmerFrameLayout.stopShimmer()
                    homeBinding.shimmer.visibility = View.GONE
                    response.data?.let {
                        topDiscountAdapter.differ.submitList(it.toList())
                    }
                }
                is Resource.Error -> {
                    Log.d("MYTAG", "Error")
                }
                is Resource.Loading -> {
                    homeBinding.topDiscount.visibility = View.INVISIBLE
                }
            }
        }

    }

    private fun provideBestSellerObserver(
        bestSellerAdapter: BestSellerAdapter,
        bestSellers: MutableLiveData<Resource<Product>>
    ) {
        bestSellers.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    homeBinding.bestSeller.visibility = View.VISIBLE
                    response.data?.let {
                        bestSellerAdapter.differ.submitList(it.toList())
                    }
                }
                is Resource.Error -> {
                    Log.d("MYTAG", "Error")
                }
                is Resource.Loading -> {
                    Log.d("MYTAG", "loading")
                }
            }
        }
    }

    private fun provideMaleTopObserver(
        menTopItemsAdapter: MenTopItemsAdapter,
        menTop: MutableLiveData<Resource<Product>>
    ) {
        menTop.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    homeBinding.menTop.visibility = View.VISIBLE
                    response.data?.let {
                        menTopItemsAdapter.differ.submitList(it.toList())
                    }
                }
                is Resource.Error -> {
                    Log.d("MYTAG", "Error")
                }
                is Resource.Loading -> {
                    Log.d("MYTAG", "loading")
                }
            }
        }
    }

    private fun setOnclickListner(it: ProductItem) {
        val bundle = Bundle().apply {
            putSerializable("selected_item", it)
        }
        findNavController().navigate(R.id.action_homeFragment_to_productDetailFragment, bundle)
    }

}