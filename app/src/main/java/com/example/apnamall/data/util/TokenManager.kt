package com.example.apnamall.data.util

import android.app.Application
import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class TokenManager @Inject constructor(@ApplicationContext application: Context) {
    private var prefs=application.getSharedPreferences("PREFS_TOKEN_FILE",Context.MODE_PRIVATE)

    fun saveToken(token:String){
        val editor=prefs.edit()
        editor.putString("USER_TOKEN",token)
        editor.apply()
    }

    fun getToken(): String? {
        return prefs.getString("USER_TOKEN",null)
    }

    fun deleteToken(){
        val editor=prefs.edit()
        editor.remove("USER_TOKEN")
        editor.apply()
    }
}