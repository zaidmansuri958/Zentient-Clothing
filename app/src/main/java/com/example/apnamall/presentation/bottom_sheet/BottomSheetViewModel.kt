package com.example.apnamall.presentation.bottom_sheet

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apnamall.data.model.cart.CartRequest
import com.example.apnamall.data.model.cart.CartResponseItem
import com.example.apnamall.data.model.order.OrderRequest
import com.example.apnamall.data.model.order.OrderResponseItem
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.use_case.SubmitOrderUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BottomSheetViewModel(private val submitOrderUseCase: SubmitOrderUseCase):ViewModel() {
    val submitOrder: MutableLiveData<Resource<OrderResponseItem>> = MutableLiveData()

    fun submitOrder(productItem: OrderRequest) = viewModelScope.launch(Dispatchers.IO) {
        val apiResult = submitOrderUseCase.execute(productItem)
        submitOrder.postValue(apiResult)
    }
}