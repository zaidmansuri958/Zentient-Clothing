package com.example.apnamall.presentation.like

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apnamall.domain.use_case.GetLikeUseCase

class LikeViewModelFactory(private val getLikeUseCase: GetLikeUseCase):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LikeViewModel(getLikeUseCase) as T
    }
}