package com.example.eb_api

import android.util.Log
import com.example.eb_api.service.EasyBrokerRetrofitBuilder
import com.example.eb_api.service.PropertiesApi
import com.example.eb_api.service.PropertiesRepository
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class TestPaginationApi {

    @Test
    fun testApiOverFlowPagination_expectedContentEmpty() {
        val  propertiesApi: PropertiesApi = EasyBrokerRetrofitBuilder.retrofitInstance.create(
            PropertiesApi::class.java)

        val response = propertiesApi.getProperties(page = 1000).execute()
        //Check for error body
        val errorBody = response.errorBody()
        assert(errorBody == null)
        //Check for success body
        val responseWrapper = response.body()
        responseWrapper?.let{
            assert(it.content.isNullOrEmpty())
        }
    }
}