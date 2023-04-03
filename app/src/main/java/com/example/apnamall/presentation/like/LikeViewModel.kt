package com.example.apnamall.presentation.like

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apnamall.data.model.like.LikeResponse
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.use_case.GetLikeUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LikeViewModel(private val getLikeUseCase: GetLikeUseCase) :ViewModel(){
    var likeItem:MutableLiveData<Resource<LikeResponse>> = MutableLiveData()

    fun getLikeItem() = viewModelScope.launch(Dispatchers.IO) {
        val apiResult = getLikeUseCase.execute()
        likeItem.postValue(apiResult)
    }
}