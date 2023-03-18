package com.example.apnamall.presentation.cart_item

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apnamall.data.model.order.OrderResponseItem
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.use_case.DeleteOrderUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CartItemViewModel(private val deleteOrderUseCase: DeleteOrderUseCase) : ViewModel() {
    val deleteOrder: MutableLiveData<Resource<OrderResponseItem>> = MutableLiveData()

    fun deleteOrder(orderId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val apiResult=deleteOrderUseCase.execute(orderId)
            deleteOrder.postValue(apiResult)
        }
    }
}