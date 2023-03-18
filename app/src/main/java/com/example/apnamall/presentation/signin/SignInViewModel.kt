package com.example.apnamall.presentation.signin

import android.text.TextUtils
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apnamall.data.model.user.LoginRequest
import com.example.apnamall.data.model.user.UserResponse
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.use_case.UserSignInUseCase
import kotlinx.coroutines.launch

class SignInViewModel(private val userSignInUseCase: UserSignInUseCase) :ViewModel(){
    val signInResponse: MutableLiveData<Resource<UserResponse>> = MutableLiveData()

    fun userSignIn(data:LoginRequest){
        viewModelScope.launch {
            val apiResult=userSignInUseCase.execute(data)
            signInResponse.postValue(apiResult)
        }
    }

    fun validateCredentials(
        email: String,
        password: String,
    ): Pair<Boolean, String> {
        var result = Pair(true, "")
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            result = Pair(false, "Please provide the credentials")
        } else if (password.length <= 5) {
            result = Pair(false, "Password length should be greater than 5")
        }
        return result
    }

}