package com.lynn.tvapp.data.datasource.show

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

class ShowApiDataSourceTest {
    @MockK
    lateinit var service: TVApiService
    private lateinit var dataSource: ShowDataSource

    @Before
    fun setUp(){
        MockKAnnotations.init(this)
        dataSource = ShowApiDataSource(service)
    }

    @Test
    fun getShow(){
        runTest {
            val mockResponse = mockk<List<ShowResponse>>(relaxed = true)
            coEvery { service.getShows(any()) } returns mockResponse
            val actualResult = dataSource.getShow()
            coVerify { service.getShows(any()) }
            assertEquals(actualResult, mockResponse)
        }
    }

}