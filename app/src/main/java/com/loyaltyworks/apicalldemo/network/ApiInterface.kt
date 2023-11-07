package com.loyaltyworks.apicalldemo.network

import com.loyaltyworks.apicalldemo.model.DemoRequest
import com.loyaltyworks.apicalldemo.model.DemoResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {

    // demo api call
    @POST("GetEventManagementMasterDetails")
    fun demoAsync(@Body demoRequest: DemoRequest): Deferred<Response<DemoResponse>>


}