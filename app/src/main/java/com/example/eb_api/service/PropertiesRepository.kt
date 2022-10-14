package com.example.eb_api.service

import android.util.Log
import com.example.eb_api.PropertiesResponse
import com.example.eb_api.model.Property
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PropertiesRepository( val propertiesApi: PropertiesApi = EasyBrokerRetrofitBuilder.retrofitInstance.create(PropertiesApi::class.java)) {

    fun getProperties(requestedPage: Int=1, callback: Callback<PropertiesResponse>) {
        propertiesApi.getProperties(requestedPage).enqueue(
            callback
        )
    }
}