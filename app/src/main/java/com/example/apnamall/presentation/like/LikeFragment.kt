package com.example.apnamall.presentation.like

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
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
        viewModel.getLikeItem()
        binding.likeRecycle.apply {
            adapter = likeAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        viewModel.likeItem.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    response.data?.let {
                        likeAdapter.differ.submitList(it.toList())
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