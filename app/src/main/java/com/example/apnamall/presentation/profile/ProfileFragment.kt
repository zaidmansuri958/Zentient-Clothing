package com.example.apnamall.presentation.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.apnamall.R
import com.example.apnamall.data.util.Resource
import com.example.apnamall.data.util.TokenManager
import com.example.apnamall.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ProfileFragmentViewModelFactory
    @Inject
    lateinit var tokenManager: TokenManager
    private lateinit var viewModel: ProfileFragmentViewModel
    private lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)
        viewModel =
            ViewModelProvider(this, viewModelFactory).get(ProfileFragmentViewModel::class.java)

        binding.logout.setOnClickListener {
            tokenManager.deleteToken()
        }

        viewModel.getUserDetails()
        viewModel.user.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    response.data?.let {
                        binding.name.text = it.name
                        binding.number.text = it.mobile_no
                        binding.address.text = it.address
                        binding.email.text=it.email
                        binding.city.text=it.pincode
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