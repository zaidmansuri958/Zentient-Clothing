package com.example.apnamall.presentation.product_detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
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
import com.example.apnamall.domain.use_case.LikedOrNotUseCase
import com.example.apnamall.domain.use_case.RemoveLikeUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductDetailViewModel(
    private val submitOrderUseCase: AddToCartUseCase,
    private val submitLikeUseCase: SubmitLikeUseCase,
    private val likedOrNotUseCase: LikedOrNotUseCase,
    private val removeLikeUseCase: RemoveLikeUseCase
) : ViewModel() {
    val submitOrder: MutableLiveData<Resource<CartResponseItem>> = MutableLiveData()
    val submitLike: MutableLiveData<Resource<LikeResponseItem>> = MutableLiveData()
    val productImages: MutableLiveData<Resource<String>> = MutableLiveData()
    var counter: Int = 1
    var isExistOrNot:Boolean?=null

    fun submitOrder(productItem: CartRequest) = viewModelScope.launch(Dispatchers.IO) {
        val apiResult = submitOrderUseCase.execute(productItem)
        submitOrder.postValue(apiResult)
    }

    fun submitLike(product: LikeRequest) {
        viewModelScope.launch {
            submitLikeUseCase.execute(product)
        }
    }

    suspend fun chekLikedOrNot(productId: String){
        isExistOrNot= likedOrNotUseCase.execute(productId)
    }

    fun removeLike(productId: String){
        viewModelScope.launch() {
            removeLikeUseCase.execute(productId)
        }
    }

    fun increaseCounter() {
        counter += 1
    }

    fun decreaseCounter() {
        counter -= 1;
    }


}