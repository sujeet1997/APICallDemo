package com.loyaltyworks.apicalldemo.view.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.loyaltyworks.apicalldemo.baseClass.BaseViewModel
import com.loyaltyworks.apicalldemo.model.DemoRequest
import com.loyaltyworks.apicalldemo.model.DemoResponse
import kotlinx.coroutines.launch

class DemoViewModel:BaseViewModel() {

    /*** Demo Api Call viewModel ***/
    private val _demoApiListLiveData = MutableLiveData<DemoResponse>()
    val demoApiListLiveData: LiveData<DemoResponse> = _demoApiListLiveData

    fun getDemoData(demoRequest: DemoRequest){
        // launch the coroutine scope
        scope.launch {
            // post the value inside live data
            _demoApiListLiveData.postValue(apiRepository.getDemoData(demoRequest))

        }

    }

}