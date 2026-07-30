package com.lynn.tvapp.data.source.network.model

import com.google.gson.annotations.SerializedName
import com.lynn.tvapp.data.source.network.model.item.Cast
import com.lynn.tvapp.data.source.network.model.item.Episode
import com.lynn.tvapp.data.source.network.model.item.Image
import com.lynn.tvapp.data.source.network.model.item.Rating
import java.util.Date

data class DetailResponse(
    @SerializedName("id") var id: Int,
    @SerializedName("url") var url: String,
    @SerializedName("name") var name: String,
    @SerializedName("type") var type: String,
    @SerializedName("language") var language: String,
    @SerializedName("genres") var genres: List<String>,
    @SerializedName("premiered") var premiered: Date,
    @SerializedName("ended") var ended: Date,
    @SerializedName("officialSite") var officialSite: String? = null,
    @SerializedName("rating") var rating: Rating? = null,
    @SerializedName("image") var image: Image,
    @SerializedName("summary") var summary: String? = null,
    @SerializedName("_embedded") var Embedded: Embedded
)

data class Embedded(
    @SerializedName("episodes") var episodes: List<Episode>,
    @SerializedName("cast") var cast: List<Cast>
)