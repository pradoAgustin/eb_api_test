package com.example.eb_api.model

import com.google.gson.annotations.SerializedName

data class Pagination (
    @SerializedName("limit") val limit: Int,
    @SerializedName("page") val page: Int,
    @SerializedName("total") val total: Int
)
{
    fun hasNextPage() :Boolean {
        return page <= total
    }
}