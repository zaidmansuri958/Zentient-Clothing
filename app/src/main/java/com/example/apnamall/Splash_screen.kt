package com.example.apnamall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.apnamall.data.util.TokenManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class Splash_screen : AppCompatActivity() {
    @Inject
    lateinit var tokenManager: TokenManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val imageView = findViewById<ImageView>(R.id.img)
        Glide.with(this).asGif()
            .load("https://firebasestorage.googleapis.com/v0/b/apna-mall-96730.appspot.com/o/Zentient%20Clothing.gif?alt=media&token=3e1abed0-94e4-4d0e-8cda-429fd7000406")
            .into(imageView)
        Handler(Looper.getMainLooper()).postDelayed({
            if (tokenManager.getToken() != null) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }
        }, 3000)
    }
}