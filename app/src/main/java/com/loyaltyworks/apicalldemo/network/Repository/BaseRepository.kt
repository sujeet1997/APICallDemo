package com.loyaltyworks.apicalldemo.network.Repository

import android.util.Log
import android.widget.Toast
import com.loyaltyworks.apicalldemo.ApplicationClass
import com.loyaltyworks.apicalldemo.network.Internet
import retrofit2.Response

/*** If request is basic auth ***/
open class BaseRepository {

    suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>, error: String): T? {

        return when (val result = apiOutput(call, error)) {
                // return API response
                is Output.Success -> result.output
                // return error msg
                is Output.Error -> {
                    // print error
                    Log.e("Error", "The $error and the ${result.exception}")
                    // return null
                    null
                }
        }
    }

    private suspend fun <T : Any> apiOutput(
        call: suspend () -> Response<T>,
        error: String
    ): Output<T> {

        // check internet connection before API call
        return if (Internet.isNetworkConnected()) {

            // Progress loader show
    //        loader(true)

            // call the network API request
            val response = call.invoke()

            // No Auth token or expired than call this statement
            // 401 -> Access denied
         /*   if(response.code() == 401) {
                // Authentication token get from API call
                if(AuthAPICall.run(ApplicationClass.appContext, BuildConfig.token_url, BuildConfig.token_request)!=null){
                    response = call.invoke() // recall method
                }
            }
         */
            // Progress loader hide
        //    loader(false)

            // 200 -> Ok
            return if (response.isSuccessful) {

                if (response.body() != null) {
                    Output.Success(response.body()!!)

                }
                else
                    Output.Error(Exception(response.errorBody().toString()))

            } else {
                if(ApplicationClass.mCurrentActivity != null) {
                    ApplicationClass.mCurrentActivity!!.runOnUiThread(Runnable {
                        Toast.makeText(ApplicationClass.mCurrentActivity, "Something went wrong try again later !! \n code : ${response.code()}", Toast.LENGTH_LONG).show()
                    })
                }

                Output.Error(Exception("OOps ... Something went wrong due to  ${response.code()} : ${response.raw()}"))
            }

        } else {

            if(ApplicationClass.mCurrentActivity != null) {
                ApplicationClass.mCurrentActivity!!.runOnUiThread(Runnable {
                    Toast.makeText(ApplicationClass.mCurrentActivity, "Check Internet Connection !!!", Toast.LENGTH_LONG).show()
                })
            }

            Output.Error(Exception("OOps ... Check Internet connection"))
        }

    }

    // Load progress dialog
    /*private fun loader(isLoad: Boolean) {
        if(ApplicationClass.mCurrentActivity != null) {
            if (isLoad) {
                // Loader display
                ApplicationClass.mCurrentActivity!!.runOnUiThread(Runnable {
                    InternetLoader.showDialog(ApplicationClass.mCurrentActivity!!) })
            } else {
                // Loader hide
                ApplicationClass.mCurrentActivity!!.runOnUiThread(Runnable { InternetLoader.dismissDialog() })
            }
        }
    }*/

}


/*** If request is token based ***/
/*
open class BaseRepository {
    suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>, error: String): T? {
        var output: T? = null
        try {

            val result = apiOutput(call, error)
            when (result) {
                is Output.Success ->
                    output = result.output
                is Output.Error -> Log.e("Error", "The $error and the ${result.exception}")
            }
            return output
        } catch (e: SocketException){
            return output
        }

    }

    private suspend fun <T : Any> apiOutput(
        call: suspend () -> Response<T>,
        error: String
    ): Output<T> {
        return if (Internet.isNetworkConnected()) {

            var response = call.invoke()

            if(response.code() == 401) {

                if(AuthAPICall.run(ApplicationClass.appContext, BuildConfig.token_url, BuildConfig.token_request)!=null){
                    response = call.invoke() // recall method
                }

            }

            return if (response.isSuccessful) {

                if (response.body() != null)
                    Output.Success(response.body()!!)
                else
                    Output.Error(Exception(response.errorBody().toString()))

            } else Output.Error(Exception("OOps .. Something went wrong due to  ${response.code()} : ${response.raw()}"))

        } else Output.Error(Exception("OOps .. Something went wrong"))
    }
}*/
