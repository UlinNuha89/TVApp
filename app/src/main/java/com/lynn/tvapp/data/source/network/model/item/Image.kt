package com.lynn.tvapp.data.source.network.model.item

import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("medium") var medium : String,
    @SerializedName("original") var original : String
)
