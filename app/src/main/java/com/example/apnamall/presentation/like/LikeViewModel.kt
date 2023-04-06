package com.example.apnamall.presentation.like

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.apnamall.data.model.like.LikeResponse
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.use_case.GetLikeUseCase
import com.example.apnamall.domain.use_case.RemoveLikeUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LikeViewModel(
    private val getLikeUseCase: GetLikeUseCase,
    private val removeLikeUseCase: RemoveLikeUseCase
) : ViewModel() {

    fun getLiked() = liveData {
        getLikeUseCase.execute().collect {
            emit(it)
        }
    }

    fun removeLike(productId:String)=viewModelScope.launch {
        removeLikeUseCase.execute(productId)
    }
}