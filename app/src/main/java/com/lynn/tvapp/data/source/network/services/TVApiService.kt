package com.lynn.tvapp.data.source.network.services

import com.lynn.tvapp.BuildConfig
import com.lynn.tvapp.data.source.network.model.DetailResponse
import com.lynn.tvapp.data.source.network.model.ShowResponse
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface TVApiService {

    @GET("shows")
    suspend fun getShows(
        @Query("page") page: Int? = 0
    ): ShowResponse

    @GET("shows/{id}")
    suspend fun getDetail(
        @Path("id") id: Int? = 1,
        @Query("embed[]") embed: List<String> = listOf("episodes", "cast")
    ): DetailResponse

    companion object {
        @JvmStatic
        operator fun invoke(): TVApiService {
            val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
            return retrofit.create(TVApiService::class.java)
        }
    }
}