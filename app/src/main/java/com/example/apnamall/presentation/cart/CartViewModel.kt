package com.example.apnamall.presentation.cart

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apnamall.data.model.cart.CartResponse
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.use_case.GetCartUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CartViewModel(private val getCartUseCase: GetCartUseCase) : ViewModel() {
    val cartItem: MutableLiveData<Resource<CartResponse>> = MutableLiveData()
    var price:Int=0

    fun getCartItem() = viewModelScope.launch(Dispatchers.IO) {
        val apiResult = getCartUseCase.execute()
        cartItem.postValue(apiResult)
    }
}