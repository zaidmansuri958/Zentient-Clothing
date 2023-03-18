package com.example.apnamall.presentation.category

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.apnamall.R
import com.example.apnamall.data.util.Resource
import com.example.apnamall.databinding.FragmentCategoryBinding
import com.example.apnamall.presentation.adapter.CategoryAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CategoryFragment : Fragment() {
    @Inject
    lateinit var categoryAdapter: CategoryAdapter

    @Inject
    lateinit var viewModelFactory: CategoryViewModelFactory

    private lateinit var binding: FragmentCategoryBinding
    private lateinit var viewModel: CategoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCategoryBinding.bind(view)
        viewModel = ViewModelProvider(this, viewModelFactory).get(CategoryViewModel::class.java)

        binding.categoryRecycle.apply {
            adapter = categoryAdapter
            layoutManager = GridLayoutManager(activity, 2)
        }

        viewModel.getCategory()
        viewModel.categoryList.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    binding.shimmerFrameLayout.stopShimmer()
                    binding.shimmer.visibility=View.GONE
                    response.data?.let {
                        categoryAdapter.differ.submitList(it.Category)
                    }
                }
                is Resource.Loading -> {
                    Log.d("MYTAG", "loading")
                }
                is Resource.Error -> {
                    Log.d("MYTAG", "error")
                }
            }

        }

        categoryAdapter.setOnItemClickListner {
            val bundle=Bundle().apply {
                putSerializable("selected_category",it)
            }
            findNavController().navigate(R.id.action_categoryFragment_to_detailCategory,bundle)
        }
    }
}

