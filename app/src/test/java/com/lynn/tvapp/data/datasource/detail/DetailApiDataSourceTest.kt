package com.lynn.tvapp.data.datasource.detail

import com.lynn.tvapp.data.source.network.model.DetailResponse
import com.lynn.tvapp.data.source.network.model.ShowResponse
import com.lynn.tvapp.data.source.network.services.TVApiService
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class DetailApiDataSourceTest {
    @MockK
    lateinit var service: TVApiService
    private lateinit var dataSource: DetailDataSource

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        dataSource = DetailApiDataSource(service)
    }

    @Test
    fun getDetail(){
        runTest {
            val mockResponse = mockk<DetailResponse>(relaxed = true)
            coEvery { service.getDetail(any()) } returns mockResponse
            val actualResult = dataSource.getDetail(1)
            coVerify { service.getDetail(any()) }
            assertEquals(actualResult, mockResponse)
        }
    }
}