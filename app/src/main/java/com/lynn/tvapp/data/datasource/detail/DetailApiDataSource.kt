package com.lynn.tvapp.data.datasource.detail

import com.lynn.tvapp.data.source.network.model.DetailResponse
import com.lynn.tvapp.data.source.network.services.TVApiService

class DetailApiDataSource(private val service: TVApiService): DetailDataSource {
    override suspend fun getDetail(id: Int?): DetailResponse {
        return service.getDetail(id)
    }
}