package com.lynn.tvapp.data.mapper

import com.lynn.tvapp.data.model.Detail
import com.lynn.tvapp.data.model.Episode
import com.lynn.tvapp.data.source.network.model.DetailResponse
import com.lynn.tvapp.data.source.network.model.item.Cast
import com.lynn.tvapp.data.source.network.model.item.EpisodeResponse

fun DetailResponse?.toDetail() = Detail(
    id = this?.id ?: 0,
    url = this?.url.orEmpty(),
    name = this?.name.orEmpty(),
    rating = this?.rating?.average?.toString() ?: "--",
    image = this?.image?.original ?: "",
    summary = this?.summary ?: "",
    episodes =this?.Embedded?.episodes.toEpisodes(),
    cast = this?.Embedded?.cast.toStrings(),
    premiered = this?.premiered?.toString() ?:""
)

fun EpisodeResponse.toEpisode() = Episode(
    season = this.season, number = this.number
)

fun Collection<EpisodeResponse>?.toEpisodes() = this?.map {
    it.toEpisode()
} ?: listOf()

fun Collection<Cast>?.toStrings() = this?.map {
    it.person.name
} ?: listOf()