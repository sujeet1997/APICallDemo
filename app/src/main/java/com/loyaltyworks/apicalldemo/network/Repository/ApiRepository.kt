package com.loyaltyworks.apicalldemo.network.Repository

import com.loyaltyworks.apicalldemo.model.DemoRequest
import com.loyaltyworks.apicalldemo.model.DemoResponse
import com.loyaltyworks.apicalldemo.network.ApiInterface

class ApiRepository(private val apiInterface: ApiInterface): BaseRepository() {

    suspend fun getDemoData(demoRequest: DemoRequest):DemoResponse?{
        return safeApiCall(
            call = { apiInterface.demoAsync(demoRequest).await()},
            error = "error call demo api"
        )
    }

}