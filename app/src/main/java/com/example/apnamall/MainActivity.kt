package com.example.apnamall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.apnamall.databinding.ActivityMainBinding
import com.razorpay.PaymentResultListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(),PaymentResultListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController:NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
        binding.bnv.setupWithNavController(navController)
    }

    override fun onPaymentSuccess(p0: String?) {
        Toast.makeText(this, "Payment Successful", Toast.LENGTH_SHORT).show()
    }

    override fun onPaymentError(p0: Int, p1: String?) {
        Toast.makeText(this, "Something went wrong",Toast.LENGTH_SHORT).show()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}