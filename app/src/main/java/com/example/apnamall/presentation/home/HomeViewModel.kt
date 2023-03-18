package com.example.apnamall.presentation.home

import android.transition.Slide
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apnamall.data.model.product.Product

import com.example.apnamall.data.model.slider.Slider

import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.use_case.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class HomeViewModel(
    private val getBestSellersUseCase: GetBestSellersUseCase,
    private val getTopDiscountUseCase: GetTopDiscountUseCase,
    private val getTopMaleUseCase: GetTopMaleUseCase,
    private val getTopFemaleUseCase: GetTopFemaleUseCase,
    private val getSliderUseCase: GetSliderUseCase,
) : ViewModel() {
    val bestSellers: MutableLiveData<Resource<Product>> = MutableLiveData()
    val topDiscount: MutableLiveData<Resource<Product>> = MutableLiveData()
    val topMale: MutableLiveData<Resource<Product>> = MutableLiveData()
    val topFemale: MutableLiveData<Resource<Product>> = MutableLiveData()
    val slider: MutableLiveData<Resource<Slider>> = MutableLiveData()


    fun getTopDiscount() = viewModelScope.launch(Dispatchers.IO) {
        val apiResult = getTopDiscountUseCase.execute()
        topDiscount.postValue(apiResult)
    }

    fun getBestSeller() = viewModelScope.launch(Dispatchers.IO) {
        val apiResult = getBestSellersUseCase.execute()
        bestSellers.postValue(apiResult)
    }

    fun getTopMale() = viewModelScope.launch(Dispatchers.IO) {
        val apiResult = getTopMaleUseCase.execute()
        topMale.postValue(apiResult)
    }

    fun getTopFemale() = viewModelScope.launch(Dispatchers.IO) {
        val apiResult = getTopFemaleUseCase.execute()
        topFemale.postValue(apiResult)
    }

    fun getSliders() = viewModelScope.launch(Dispatchers.IO) {
        val apiResult = getSliderUseCase.execute()
        slider.postValue(apiResult)
    }
}