package com.example.eb_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.eb_api.model.Property
import com.example.eb_api.service.PropertiesRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var currentPagination = 1
    val propertiesRepository by lazy { PropertiesRepository() }
    val callback =   object : Callback<PropertiesResponse> {
        override fun onResponse(
            call: Call<PropertiesResponse>,
            response: Response<PropertiesResponse>
        ) {
            response.body()?.let {
                if(it.hasNextPage()) {
                    currentPagination++
                    Log.d("pagination", it.pagination.page.toString())
                    it.printPropertiesTitle()
                } else {
                    Log.d("error", "no more pagination")
                }

            }

        }

        override fun onFailure(call: Call<PropertiesResponse>, t: Throwable) {
            Log.d("error", t.localizedMessage)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setPropertiesButtonClick()
    }

    private fun setPropertiesButtonClick() {
        val propertyButton = findViewById<View>(R.id.propertiesButton) as Button
        propertyButton.setOnClickListener(View.OnClickListener {
            propertiesRepository.getProperties(currentPagination, callback)
        })

    }


}