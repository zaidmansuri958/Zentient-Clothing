package com.example.apnamall.presentation.video

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apnamall.domain.use_case.GetVideoUseCase

class VideoViewModelFactory(private val getVideoUseCase: GetVideoUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return VideoViewModel(getVideoUseCase) as T
    }
}