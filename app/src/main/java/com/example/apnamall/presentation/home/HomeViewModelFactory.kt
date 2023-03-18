package com.example.apnamall.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apnamall.domain.use_case.*

class HomeViewModelFactory(
    private val getBestSellersUseCase: GetBestSellersUseCase,
    private val getTopDiscountUseCase: GetTopDiscountUseCase,
    private val getTopMaleUseCase: GetTopMaleUseCase,
    private val getTopFemaleUseCase: GetTopFemaleUseCase,
    private val sliderUseCase: GetSliderUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(
            getBestSellersUseCase,
            getTopDiscountUseCase,
            getTopMaleUseCase,
            getTopFemaleUseCase,
            sliderUseCase
        ) as T
    }
}