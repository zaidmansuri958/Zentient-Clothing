package com.example.apnamall.presentation.like

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apnamall.R
import com.example.apnamall.data.util.Resource
import com.example.apnamall.databinding.FragmentLikeBinding
import com.example.apnamall.presentation.adapter.LikeAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LikeFragment : Fragment() {
    @Inject
    lateinit var likeViewModelFactory: LikeViewModelFactory

    @Inject
    lateinit var likeAdapter: LikeAdapter

    private lateinit var viewModel: LikeViewModel

    private lateinit var binding: FragmentLikeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_like, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLikeBinding.bind(view)
        viewModel = ViewModelProvider(this, likeViewModelFactory).get(LikeViewModel::class.java)
        binding.likeRecycle.apply {
            adapter = likeAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        likeAdapter.setOnLikeClickListner {
            viewModel.removeLike(it)
        }
        likeAdapter.setOnItemClickListner {
            val bundle = Bundle().apply {
                putSerializable("selected_item", it)
            }
            findNavController().navigate(R.id.action_likeFragment_to_productDetailFragment, bundle)
        }
        viewModel.getLiked().observe(viewLifecycleOwner, {
            likeAdapter.differ.submitList(it)
        })
    }
}