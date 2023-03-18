package com.example.apnamall.presentation.product_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apnamall.data.model.order.OrderRequest
import com.example.apnamall.data.model.order.OrderResponse
import com.example.apnamall.data.model.order.OrderResponseItem
import com.example.apnamall.data.model.product.Product
import com.example.apnamall.data.model.product.ProductItem
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.use_case.SubmitOrderUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductDetailViewModel(private val submitOrderUseCase: SubmitOrderUseCase) : ViewModel() {
    val submitOrder: MutableLiveData<Resource<OrderResponseItem>> = MutableLiveData()
    val productImages: MutableLiveData<Resource<String>> = MutableLiveData()
    var counter: Int = 1

    fun submitOrder(productItem: OrderRequest) = viewModelScope.launch(Dispatchers.IO) {
        val apiResult = submitOrderUseCase.execute(productItem)
        submitOrder.postValue(apiResult)
    }

    fun increaseCounter() {
        counter += 1
    }

    fun decreaseCounter() {
        counter -= 1;
    }


}