package com.example.apnamall.presentation.signin

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.apnamall.MainActivity
import com.example.apnamall.R
import com.example.apnamall.data.model.user.LoginRequest
import com.example.apnamall.data.model.user.UserRequest
import com.example.apnamall.data.util.Resource
import com.example.apnamall.data.util.TokenManager
import com.example.apnamall.databinding.FragmentSignInBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SignIn : Fragment() {

    @Inject
    lateinit var signInViewModelFactory: SignInViewModelFactory

    @Inject
    lateinit var tokenManager: TokenManager

    private lateinit var binding: FragmentSignInBinding
    private lateinit var viewModel: SignInViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if(tokenManager.getToken()!=null){
            mainActivity()
        }
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignInBinding.bind(view)
        viewModel = ViewModelProvider(this, signInViewModelFactory).get(SignInViewModel::class.java)
        binding.signup.setOnClickListener {
            it.findNavController().popBackStack()
        }

        binding.loginBtn.setOnClickListener {
            val email = binding.userEmail.text.toString()
            val password = binding.userPwd.text.toString()
            val validate =
                viewModel.validateCredentials(email, password)
            if (validate.first) {
                binding.progressBar.isVisible = true
                viewModel.userSignIn(LoginRequest(email, password))
            } else {
                Toast.makeText(activity, validate.second, Toast.LENGTH_SHORT).show()
            }

        }

        viewModel.signInResponse.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    response.data?.let {
                        tokenManager.saveToken(it.token)
                        binding.progressBar.isVisible = false
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