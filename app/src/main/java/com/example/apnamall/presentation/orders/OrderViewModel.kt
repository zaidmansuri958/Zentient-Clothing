package com.example.apnamall.presentation.orders

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.apnamall.data.model.cart.CartResponseItem
import com.example.apnamall.data.model.category.Category
import com.example.apnamall.data.model.order.OrderResponse
import com.example.apnamall.data.model.order.OrderResponseItem
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.use_case.DeleteOrderUseCase
import com.example.apnamall.domain.use_case.GetOrderUseCase
import kotlinx.coroutines.launch

class OrderViewModel(
    private val getOrderUseCase: GetOrderUseCase,
    private val deleteOrderUseCase: DeleteOrderUseCase
) : ViewModel() {
    val orderList: MutableLiveData<Resource<OrderResponse>> = MutableLiveData()
    val deleteOrder: MutableLiveData<Resource<OrderResponseItem>> = MutableLiveData()

    fun getOrder() = viewModelScope.launch {
        val apiResult = getOrderUseCase.execute()
        orderList.postValue(apiResult)
    }

    fun deleteOrder(productId:String)=viewModelScope.launch {
        val apiResult=deleteOrderUseCase.execute(productId)
        deleteOrder.postValue(apiResult)
    }
}