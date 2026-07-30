package com.lynn.tvapp.data.source.network.model.item

import com.google.gson.annotations.SerializedName

data class EpisodeResponse(
    @SerializedName("id") var id: Int,
    @SerializedName("url") var url: String,
    @SerializedName("name") var name: String,
    @SerializedName("season") var season: Int,
    @SerializedName("number") var number: Int,
    @SerializedName("rating") var rating: Rating,
)
