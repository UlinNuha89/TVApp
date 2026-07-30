package com.lynn.tvapp.data.datasource.detail

import com.lynn.tvapp.data.source.network.model.DetailResponse

interface DetailDataSource {
    suspend fun getDetail(id: Int?): DetailResponse
}