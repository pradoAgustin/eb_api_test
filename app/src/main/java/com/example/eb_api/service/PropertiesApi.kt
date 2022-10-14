package com.example.eb_api.service

import com.example.eb_api.PropertiesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PropertiesApi {
    @GET("properties")
    fun getProperties(
        @Query("page") page: Int): Call<PropertiesResponse>
}

