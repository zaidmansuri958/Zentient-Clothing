package com.example.apnamall.presentation.video

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apnamall.data.model.product.ProductItem
import com.example.apnamall.data.model.video.Video
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.use_case.GetVideoUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VideoViewModel(
    private val getVideoUseCase: GetVideoUseCase,
) : ViewModel() {
    val video: MutableLiveData<Resource<Video>> = MutableLiveData()

    fun getVideo() = viewModelScope.launch(Dispatchers.IO) {
        val apiResult = getVideoUseCase.execute()
        video.postValue(apiResult)
    }

}