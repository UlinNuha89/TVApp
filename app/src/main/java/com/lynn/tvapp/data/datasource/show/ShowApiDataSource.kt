package com.lynn.tvapp.data.datasource.show

import com.lynn.tvapp.data.source.network.model.ShowResponse
import com.lynn.tvapp.data.source.network.services.TVApiService

class ShowApiDataSource(private val service: TVApiService) : ShowDataSource {
    override suspend fun getShow(): List<ShowResponse> {
        return service.getShows(0)
    }
}