package com.lynn.tvapp.data.repository

import com.lynn.tvapp.data.datasource.show.ShowDataSource
import com.lynn.tvapp.data.mapper.toShows
import com.lynn.tvapp.data.model.Show
import com.lynn.tvapp.utils.ResultWrapper
import com.lynn.tvapp.utils.proceedFlow
import kotlinx.coroutines.flow.Flow

interface ShowRepository {
    fun getShow(): Flow<ResultWrapper<List<Show>>>
}

class ShowRepositoryImpl(private val dataSource: ShowDataSource) : ShowRepository {
    override fun getShow(): Flow<ResultWrapper<List<Show>>> {
        return proceedFlow { dataSource.getShow().toShows() }
    }
}