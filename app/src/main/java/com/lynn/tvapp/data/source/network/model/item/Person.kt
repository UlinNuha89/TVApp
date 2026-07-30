package com.lynn.tvapp.data.source.network.model.item

import com.google.gson.annotations.SerializedName

data class Person(
    @SerializedName("id") var id: Int,
    @SerializedName("url") var url: String,
    @SerializedName("name") var name: String,
    @SerializedName("image") var image: Image,
)
