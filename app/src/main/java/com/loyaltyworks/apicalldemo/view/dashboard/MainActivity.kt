package com.loyaltyworks.apicalldemo.view.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.loyaltyworks.apicalldemo.view.dashboard.adapter.DemoAdapter
import com.loyaltyworks.apicalldemo.databinding.ActivityMainBinding
import com.loyaltyworks.apicalldemo.model.DemoRequest

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: DemoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DemoViewModel::class.java)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        callApi()



        viewModel.demoApiListLiveData.observe(this, Observer {
            if (it != null && !it.lstEventManagementDetailsAPI.isNullOrEmpty()){
                binding.demoRecycler.visibility = View.VISIBLE
                binding.errorTxt.visibility = View.GONE

                binding.demoRecycler.adapter = DemoAdapter(it.lstEventManagementDetailsAPI)
            }else{
                binding.errorTxt.visibility = View.VISIBLE
                binding.demoRecycler.visibility = View.GONE
            }
        })
    }

    private fun callApi() {
        viewModel.getDemoData(
            DemoRequest(
                actionType = "2",
                actorId = "372"
//                pageSize = "20",
//                startIndex = "1"
            )
        )
    }
}