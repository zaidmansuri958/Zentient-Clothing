package com.example.apnamall.presentation.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apnamall.domain.use_case.UserSignUpUseCase

class SignUpViewModelFactory(private val userSignUpUseCase: UserSignUpUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SignUpViewModel(userSignUpUseCase) as T
    }
}