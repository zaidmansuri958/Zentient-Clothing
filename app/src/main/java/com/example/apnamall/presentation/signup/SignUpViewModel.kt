package com.example.apnamall.presentation.signup


import android.text.TextUtils
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apnamall.data.model.user.UserRequest
import com.example.apnamall.data.model.user.UserResponse
import com.example.apnamall.data.util.Resource
import com.example.apnamall.domain.use_case.UserSignUpUseCase
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.Response

class SignUpViewModel(private val userSignUpUseCase: UserSignUpUseCase) : ViewModel() {
    val signupResponse: MutableLiveData<Resource<UserResponse>> = MutableLiveData()

    fun userSignUp(
        data: UserRequest
    ) {
        signupResponse.postValue(Resource.Loading())
        viewModelScope.launch {
            val apiResult = userSignUpUseCase.execute(data)
            signupResponse.postValue(apiResult)
        }
    }

    /******* SET CREDENTIALS FOR SIGN-UP *******/
    fun validateCredentials(
        name: String,
        email: String,
        password: String,
        mobile: String,
        adress: String,
        pincode: String
    ): Pair<Boolean, String> {
        var result = Pair(true, "")
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password) ||
            TextUtils.isEmpty(mobile) || TextUtils.isEmpty(adress) || TextUtils.isEmpty(pincode)
        ) {
            result = Pair(false, "Please provide the credentials")
        } else if (password.length <= 5) {
            result = Pair(false, "Password length should be greater than 5")
        } else if (mobile.length > 10 || mobile.length < 10) {
            result = Pair(false, "Mobile number should be 10 digit long")
        }
        return result
    }




}