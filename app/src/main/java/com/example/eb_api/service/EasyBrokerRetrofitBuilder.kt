package com.example.eb_api.service

import com.example.eb_api.BASE_URL
import com.example.eb_api.EB_API_KEY
import okhttp3.Interceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException


object EasyBrokerRetrofitBuilder {

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("X-Authorization", EB_API_KEY)
                .addHeader("accept","application/json")
            chain.proceed(request.build())
        }
        .build()
        private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofitInstance: Retrofit
            get() {
                return retrofit
            }
}