package com.example.apnamall.presentation.orders

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apnamall.R
import com.example.apnamall.data.util.Resource
import com.example.apnamall.databinding.FragmentOrderBinding
import com.example.apnamall.presentation.adapter.OrderAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OrderFragment : Fragment() {
    private lateinit var binding: FragmentOrderBinding

    @Inject
    lateinit var orderAdapter: OrderAdapter

    @Inject
    lateinit var viewModelFactory: OrderViewModelFactory

    private lateinit var viewModel: OrderViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_order, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOrderBinding.bind(view)
        viewModel = ViewModelProvider(this, viewModelFactory).get(OrderViewModel::class.java)

        viewModel.getOrder()
        viewModel.orderList.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Success -> {
                    result.data?.let {
                        orderAdapter.differ.submitList(it)
                    }
                }
                is Resource.Loading -> {
                    Toast.makeText(activity, "Loading", Toast.LENGTH_SHORT).show()
                }
                is Resource.Error -> {
                    Toast.makeText(activity, result.message.toString(), Toast.LENGTH_LONG)
                        .show()
                }
            }
        })

        binding.orderRecycle.apply {
            adapter = orderAdapter
            layoutManager = LinearLayoutManager(activity)
        }

        orderAdapter.setOnItemClickListner {

            var builder: AlertDialog.Builder = AlertDialog.Builder(activity);
            builder.setMessage("Do you want to cancel order ?")
            builder.setCancelable(false)
            builder.setPositiveButton(
                "Yes",
                DialogInterface.OnClickListener { dialog: DialogInterface?, which: Int ->
                    viewModel.deleteOrder(it)
                })

            builder.setNegativeButton(
                "Cancel",
                DialogInterface.OnClickListener { dialog: DialogInterface?, which: Int ->
                    dialog!!.cancel()
                })
            val alertDialog: AlertDialog = builder.create()
            alertDialog.show()

        }
        viewModel.deleteOrder.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Success -> {
                    Toast.makeText(activity, "Order Cancel Successfully", Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading -> {
                    Toast.makeText(activity, "Order Loading", Toast.LENGTH_SHORT).show()
                }
                is Resource.Error -> {
                    Toast.makeText(activity, result.message.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        })

    }
}