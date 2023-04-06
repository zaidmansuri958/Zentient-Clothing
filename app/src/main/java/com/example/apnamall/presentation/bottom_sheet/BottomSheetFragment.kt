package com.example.apnamall.presentation.bottom_sheet

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.apnamall.R
import com.example.apnamall.data.model.order.OrderRequest
import com.example.apnamall.data.util.Resource
import com.example.apnamall.databinding.FragmentBottomSheetBinding
import com.example.apnamall.presentation.adapter.CartAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import dagger.hilt.android.AndroidEntryPoint
import org.json.JSONException
import org.json.JSONObject
import javax.inject.Inject

@AndroidEntryPoint
class BottomSheetFragment : BottomSheetDialogFragment(), PaymentResultListener {
    private lateinit var binding: FragmentBottomSheetBinding
    private var paymentType: String? = null

    @Inject
    lateinit var cartAdapter: CartAdapter

    @Inject
    lateinit var bottomSheetViewModelFactory: BottomSheetViewModelFactory

    private lateinit var viewModel: BottomSheetViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBottomSheetBinding.bind(view)
        viewModel = ViewModelProvider(
            this,
            bottomSheetViewModelFactory
        ).get(BottomSheetViewModel::class.java)

        setOnCheckedChangeListener()

        binding.submitBtn.setOnClickListener {
            paymentProcess()
        }
    }

    private fun setOnCheckedChangeListener() {
        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.online ->
                    paymentType = binding.online.text.toString()
                R.id.cod ->
                    paymentType = binding.cod.text.toString()
            }
        }
    }

    private fun onlinePay() {
        var checkout = Checkout()
        var jsonobject = JSONObject()
        checkout.setKeyID("rzp_test_v276RMjWgQ5MHe");
        checkout.setImage(R.drawable.sample)

        try {
            jsonobject.put("name", "Zenetian Clothing")
            jsonobject.put("description", "Test payment");
            jsonobject.put("currency", "INR")
            jsonobject.put("amount", Integer.parseInt(requireArguments().getString("price")!!))
            jsonobject.put("theme.color", "#060618");
            var prefill = JSONObject()
            prefill.put("contact", "7201805489")
            prefill.put("email", "zaidmansuri.@gmail.com")
            jsonobject.put("prefill", prefill)

            checkout.open(activity, jsonobject)

        } catch (ex: JSONException) {
            Log.d("PAYMENT", ex.printStackTrace().toString())
        }
    }

    private fun offlinePay() {
        for (i in cartAdapter.differ.currentList) {
            viewModel.submitOrder(
                OrderRequest(
                    i.productDesc,
                    i.productID,
                    i.productImg1,
                    i.productImg2,
                    i.productImg3,
                    i.productName,
                    i.productPrice,
                    i.quantity,
                    i.size,
                    "Pick Up"
                )
            )
        }
    }

    private fun paymentProcess() {
        if (paymentType == null) {
            Toast.makeText(activity, "Please select payment method", Toast.LENGTH_SHORT).show()
        } else {
            if (paymentType.equals("Online")) {
                onlinePay()
            } else {
                offlinePay()
            }
            viewModel.submitOrder.observe(viewLifecycleOwner, Observer { response ->
                when (response) {
                    is Resource.Success -> {
                        Toast.makeText(activity, "Successfully completed", Toast.LENGTH_SHORT)
                            .show()
                    }
                    is Resource.Loading -> {
                        Toast.makeText(activity, "Loading", Toast.LENGTH_SHORT).show()
                    }
                    is Resource.Error -> {
                        Toast.makeText(
                            activity,
                            response.message.toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            })
        }
    }

    override fun onPaymentSuccess(p0: String?) {
        Toast.makeText(activity, "Payment Successful", Toast.LENGTH_SHORT).show()
    }

    override fun onPaymentError(p0: Int, p1: String?) {
        Log.d("PAYMENT", "something went wrong")
    }


}