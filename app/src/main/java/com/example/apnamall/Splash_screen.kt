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
            .load(R.drawable.logo_anim)
            .into(imageView)
        Handler(Looper.getMainLooper()).postDelayed({
            if (tokenManager.getToken() != null) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }
        }, 4500)
    }
}