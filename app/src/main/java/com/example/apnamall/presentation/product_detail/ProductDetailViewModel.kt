package com.example.apnamall.presentation.product_detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apnamall.data.model.like.LikeRequest
import com.example.apnamall.data.model.like.LikeResponseItem
import com.example.apnamall.data.model.cart.CartRequest
import com.example.apnamall.data.model.cart.CartResponseItem
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.use_case.SubmitLikeUseCase
import com.example.apnamall.domain.use_case.AddToCartUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductDetailViewModel(
    private val submitOrderUseCase: AddToCartUseCase,
    private val submitLikeUseCase: SubmitLikeUseCase
) : ViewModel() {
    val submitOrder: MutableLiveData<Resource<CartResponseItem>> = MutableLiveData()
    val submitLike: MutableLiveData<Resource<LikeResponseItem>> = MutableLiveData()
    val productImages: MutableLiveData<Resource<String>> = MutableLiveData()
    var counter: Int = 1

    fun submitOrder(productItem: CartRequest) = viewModelScope.launch(Dispatchers.IO) {
        val apiResult = submitOrderUseCase.execute(productItem)
        submitOrder.postValue(apiResult)
    }

    fun submitLike(productItem: LikeRequest)=viewModelScope.launch(Dispatchers.IO){
        val apiResult=submitLikeUseCase.execute(productItem)
        submitLike.postValue(apiResult)
    }

    fun increaseCounter() {
        counter += 1
    }

    fun decreaseCounter() {
        counter -= 1;
    }


}