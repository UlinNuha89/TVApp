package com.lynn.tvapp.data.datasource.show

import com.lynn.tvapp.data.source.network.model.ShowResponse

interface ShowDataSource {
    suspend fun getShow(): List<ShowResponse>
}