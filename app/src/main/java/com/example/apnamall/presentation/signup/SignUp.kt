package com.example.apnamall.presentation.signup

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.apnamall.MainActivity
import com.example.apnamall.R
import com.example.apnamall.data.model.user.UserRequest
import com.example.apnamall.data.util.Resource
import com.example.apnamall.data.util.TokenManager
import com.example.apnamall.databinding.FragmentSignUpBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SignUp : Fragment() {
    @Inject
    lateinit var userViewModelFactory: SignUpViewModelFactory

    @Inject
    lateinit var tokenManager: TokenManager

    private lateinit var viewModel: SignUpViewModel
    private lateinit var binding: FragmentSignUpBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignUpBinding.bind(view)
        viewModel = ViewModelProvider(this, userViewModelFactory).get(SignUpViewModel::class.java)
        binding.login.setOnClickListener {
            findNavController().navigate(R.id.action_signUp_to_signIn)
        }
        binding.signupBtn.setOnClickListener {
            val name = binding.userName.text.toString()
            val email = binding.userEmail.text.toString()
            val mobile = binding.userMobile.text.toString()
            val password = binding.userPwd.text.toString()
            val address = binding.userAdress.text.toString()
            val pincode = binding.userPincode.text.toString()
            val validate =
                viewModel.validateCredentials(name, email, password, mobile, address, pincode)
            if (validate.first) {
                binding.progressBar.isVisible = true
                viewModel.userSignUp(UserRequest(name, email, mobile, address, password, pincode))
            } else {
                Toast.makeText(activity, validate.second, Toast.LENGTH_SHORT).show()
            }

        }



        viewModel.signupResponse.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    response.data?.let {
                        binding.progressBar.isVisible = false
                        tokenManager.saveToken(it.token)
                        mainActivity()
                    }
                }
                is Resource.Loading -> {
                    binding.progressBar.isVisible = true
                }
                is Resource.Error -> {
                    binding.progressBar.isVisible = false
                    Toast.makeText(activity, response.message.toString(), Toast.LENGTH_LONG).show()
                }
            }
        })

    }

    private fun mainActivity() {
        val intent = Intent(activity, MainActivity::class.java)
        startActivity(intent)
    }

}