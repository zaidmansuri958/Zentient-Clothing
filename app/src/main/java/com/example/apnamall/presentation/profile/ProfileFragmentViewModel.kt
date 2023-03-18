package com.example.apnamall.presentation.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apnamall.data.model.user.User
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.use_case.GetUserDetailUseCase
import kotlinx.coroutines.launch

class ProfileFragmentViewModel(private val getUserDetailUseCase: GetUserDetailUseCase):ViewModel() {

    val user:MutableLiveData<Resource<User>> = MutableLiveData()

    fun getUserDetails()= viewModelScope.launch {
        val apiResult=getUserDetailUseCase.execute()
        user.postValue(apiResult)
    }
}