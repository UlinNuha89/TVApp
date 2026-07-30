package com.lynn.tvapp.data.source.network.model

import com.google.gson.annotations.SerializedName
import com.lynn.tvapp.data.source.network.model.item.Rating
import com.lynn.tvapp.data.source.network.model.item.Image
import java.util.Date

data class ShowResponse(
    @SerializedName("id") var id: Int,
    @SerializedName("url") var url: String,
    @SerializedName("name") var name: String,
    @SerializedName("genres") var genres: List<String>,
    @SerializedName("status") var status: String,
    @SerializedName("premiered") var premiered: Date,
    @SerializedName("ended") var ended: Date,
    @SerializedName("officialSite") var officialSite: String,
    @SerializedName("rating") var rating: Rating,
    @SerializedName("image") var image: Image,
    @SerializedName("summary") var summary: String,
)