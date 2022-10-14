package com.example.eb_api.model

import com.google.gson.annotations.SerializedName

data class Property(
    @SerializedName("public_id") val publicId: String,
    @SerializedName("title") val title: String,
    @SerializedName("title_image_full") val titleImageFull: String)
