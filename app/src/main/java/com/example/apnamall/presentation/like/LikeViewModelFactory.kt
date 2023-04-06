package com.example.apnamall.presentation.like

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apnamall.domain.use_case.GetLikeUseCase
import com.example.apnamall.domain.use_case.RemoveLikeUseCase

class LikeViewModelFactory(
    private val getLikeUseCase: GetLikeUseCase,
    private val removeLikeUseCase: RemoveLikeUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LikeViewModel(getLikeUseCase,removeLikeUseCase) as T
    }
}