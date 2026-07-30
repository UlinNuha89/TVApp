package com.lynn.tvapp.data.repository

import com.lynn.tvapp.data.datasource.detail.DetailDataSource
import com.lynn.tvapp.data.mapper.toDetail
import com.lynn.tvapp.data.model.Detail
import com.lynn.tvapp.utils.ResultWrapper
import com.lynn.tvapp.utils.proceedFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch

interface DetailRepository {
    fun getDetail(id: Int): Flow<ResultWrapper<Detail>>
}

class DetailRepositoryImpl(private val dataSource: DetailDataSource) : DetailRepository {
    override fun getDetail(id: Int): Flow<ResultWrapper<Detail>> {
        return proceedFlow {
            dataSource.getDetail(id).toDetail()
        }.catch {
            emit(ResultWrapper.Error(Exception(it)))
        }
    }

}