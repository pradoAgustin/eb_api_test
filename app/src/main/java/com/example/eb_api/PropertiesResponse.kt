package com.example.eb_api

import android.util.Log
import com.example.eb_api.model.Pagination
import com.example.eb_api.model.Property
import com.google.gson.annotations.SerializedName

data class PropertiesResponse(
    @SerializedName("pagination") val pagination: Pagination,
    @SerializedName("content") val content: List<Property>?= null) {

    fun hasNextPage() :Boolean {
        return pagination.hasNextPage()
    }

    fun printPropertiesTitle() {
        content?.forEach {
            Log.d("property_name", it.title)
        }
    }
}