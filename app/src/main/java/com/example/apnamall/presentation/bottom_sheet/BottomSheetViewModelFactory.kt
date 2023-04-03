package com.example.apnamall.presentation.bottom_sheet

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apnamall.domain.use_case.SubmitOrderUseCase

class BottomSheetViewModelFactory(private val submitOrderUseCase: SubmitOrderUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BottomSheetViewModel(submitOrderUseCase) as T
    }
}