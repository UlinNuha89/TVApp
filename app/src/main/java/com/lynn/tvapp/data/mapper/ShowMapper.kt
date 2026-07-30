package com.lynn.tvapp.data.mapper

import com.lynn.tvapp.data.model.Show
import com.lynn.tvapp.data.source.network.model.ShowResponse

fun ShowResponse?.toShow() = Show(
    id = this?.id ?: 0,
    url = this?.url.orEmpty(),
    name = this?.name.orEmpty(),
    rating = this?.rating?.average?.toString() ?: "--",
    image = this?.image?.medium ?: ""
)

fun Collection<ShowResponse>?.toShows() = this?.map {
    it.toShow()
} ?: listOf()