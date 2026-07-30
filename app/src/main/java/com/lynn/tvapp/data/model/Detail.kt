package com.lynn.tvapp.data.model

data class Detail(
    var id: Int,
    var url: String,
    var name: String,
    var rating: String,
    var image: String,
    var summary: String,
    var episodes: List<Episode>,
    var cast : List<String>
    )

data class Episode(
    var season: Int,
    var number: Int
)
