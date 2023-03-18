package com.example.apnamall.presentation.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apnamall.domain.use_case.UserSignInUseCase

class SignInViewModelFactory(private val userSignInUseCase: UserSignInUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SignInViewModel(userSignInUseCase) as T
    }
}