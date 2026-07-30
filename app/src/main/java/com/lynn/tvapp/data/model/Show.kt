package com.lynn.tvapp.data.model

import com.lynn.tvapp.data.source.network.model.item.Image
import com.lynn.tvapp.data.source.network.model.item.Rating
import java.util.Date

data class Show(
    var id: Int,
    var url: String,
    var name: String,
    var rating: String,
    var image: String,
)
