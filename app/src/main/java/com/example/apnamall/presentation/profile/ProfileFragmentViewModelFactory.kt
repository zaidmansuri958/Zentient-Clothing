package com.example.apnamall.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apnamall.domain.use_case.GetUserDetailUseCase

class ProfileFragmentViewModelFactory(private val getUserDetailUseCase: GetUserDetailUseCase):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProfileFragmentViewModel(getUserDetailUseCase) as T
    }
}