package com.example.apnamall.presentation.cart_item

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apnamall.data.model.cart.CartResponseItem
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.use_case.DeleteCartItemUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CartItemViewModel(private val deleteCartItemUseCase: DeleteCartItemUseCase) : ViewModel() {
    val removeCart: MutableLiveData<Resource<CartResponseItem>> = MutableLiveData()

    fun removeCart(orderId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val apiResult=deleteCartItemUseCase.execute(orderId)
            removeCart.postValue(apiResult)
        }
    }
}