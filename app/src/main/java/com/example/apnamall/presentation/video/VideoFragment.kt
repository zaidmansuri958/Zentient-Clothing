package com.example.apnamall.presentation.video

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.apnamall.R
import com.example.apnamall.data.model.product.ProductItem
import com.example.apnamall.data.util.Resource
import com.example.apnamall.databinding.FragmentVideoBinding
import com.example.apnamall.presentation.adapter.VideoAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class VideoFragment : Fragment() {
    @Inject
    lateinit var videoViewModelFactory: VideoViewModelFactory

    @Inject
    lateinit var videoAdapter: VideoAdapter

    private lateinit var binding: FragmentVideoBinding
    private lateinit var viewModel: VideoViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_video, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentVideoBinding.bind(view)
        viewModel = ViewModelProvider(this, videoViewModelFactory).get(VideoViewModel::class.java)

        binding.viewPager.apply {
            adapter = videoAdapter
        }
        viewModel.getVideo()
        viewModel.video.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    response?.data.let {
                        it!!.shuffle()
                        binding.progressBar.isVisible = false
                        videoAdapter.differ.submitList(it)
                    }
                }
                is Resource.Loading -> {
                    binding.progressBar.isVisible = true
                }
                is Resource.Error -> {
                    binding.progressBar.isVisible = false
                    Toast.makeText(activity, "Something went wrong", Toast.LENGTH_SHORT).show()
                }
            }

        })

        videoAdapter.setOnItemClickListner {
            val bundle = Bundle().apply {
                putSerializable("selected_item", it)
            }
            findNavController().navigate(R.id.action_videoFragment_to_productDetailFragment, bundle)
        }
    }

}