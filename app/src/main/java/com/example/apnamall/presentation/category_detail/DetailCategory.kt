package com.example.apnamall.presentation.category_detail

import android.os.Bundle
import android.transition.TransitionInflater
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.apnamall.R
import com.example.apnamall.data.model.product.Product
import com.example.apnamall.data.util.Resource
import com.example.apnamall.databinding.FragmentDetailCategoryBinding
import com.example.apnamall.presentation.adapter.CategoryAdapter
import com.example.apnamall.presentation.adapter.product.*
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@AndroidEntryPoint
class DetailCategory : Fragment() {

    @Inject
    lateinit var productAdapter: ProductAdapter

    @Inject
    lateinit var detailCategoryViewModelFactory: DetailCategoryViewModelFactory

    lateinit var viewModel: DetailCategoryViewModel

    private lateinit var binding: FragmentDetailCategoryBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailCategoryBinding.bind(view)
        viewModel = ViewModelProvider(
            this,
            detailCategoryViewModelFactory
        ).get(DetailCategoryViewModel::class.java)
        val args: DetailCategoryArgs by navArgs()
        val category = args.selectedCategory
        binding.categoryName.text = category.categoryName
        binding.categoryDetailRecycle.apply {
            adapter = productAdapter
            layoutManager = GridLayoutManager(activity, 2)
        }

        when (category.categoryName) {
            "Men Pants" -> {
                viewModel.getMalePants()
                provideObserver(viewModel.malePants)
            }
            "Women Pants" -> {
                viewModel.getFemalePants()
                provideObserver(viewModel.femalePants)
            }
            "Men Shirts" -> {
                viewModel.getMaleShirts()
                provideObserver(viewModel.maleShirts)
            }
            "Men Shoes" -> {
                viewModel.getMaleShoes()
                provideObserver(viewModel.maleShoes)
            }
            "Men TShirt" -> {
                viewModel.getMaleTShirts()
                provideObserver(viewModel.maleTShirts)
            }
            "Women Traditional" -> {
                viewModel.getFemaleTraditional()
                provideObserver(viewModel.femaleTraditionals)
            }
            "Women Party Dress" -> {
                viewModel.getFemaleParty()
                provideObserver(viewModel.femaleParty)
            }
            "Women Shoes" -> {
                viewModel.getFemaleShoes()
                provideObserver(viewModel.femaleShoes)
            }
        }

        productAdapter.setOnItemClickListner { productItem, Imageview, TextView, TextView1 ->
            val extras = FragmentNavigatorExtras(
                Imageview to productItem._id.toString(),
                TextView to productItem._id + "name",
                TextView1 to productItem._id + "price"
            )
            val bundle = Bundle().apply {
                putSerializable("selected_item", productItem)
            }
            findNavController().navigate(
                R.id.action_detailCategory_to_productDetailFragment,
                bundle, null, extras
            )
        }


    }

    fun provideObserver(data: MutableLiveData<Resource<Product>>) {
        data.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    binding.shimmerFrameLayout.stopShimmer()
                    binding.shimmer.visibility = View.GONE
                    response.data?.let {
                        productAdapter.differ.submitList(it)
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
}


