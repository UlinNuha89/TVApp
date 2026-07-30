package com.lynn.tvapp.data.source.network.model.item

import com.google.gson.annotations.SerializedName


data class Rating(
    @SerializedName("average") var average : Double? = null
)