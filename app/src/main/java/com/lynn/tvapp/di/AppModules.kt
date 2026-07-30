package com.lynn.tvapp.di

import com.lynn.tvapp.data.datasource.detail.DetailApiDataSource
import com.lynn.tvapp.data.datasource.detail.DetailDataSource
import com.lynn.tvapp.data.datasource.show.ShowApiDataSource
import com.lynn.tvapp.data.datasource.show.ShowDataSource
import com.lynn.tvapp.data.repository.DetailRepository
import com.lynn.tvapp.data.repository.DetailRepositoryImpl
import com.lynn.tvapp.data.repository.ShowRepository
import com.lynn.tvapp.data.repository.ShowRepositoryImpl
import com.lynn.tvapp.data.source.network.services.TVApiService
import com.lynn.tvapp.presentation.detail.DetailViewModel
import com.lynn.tvapp.presentation.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object AppModules {
    private val networkModule =
        module {
            single<TVApiService> { TVApiService.invoke() }
        }
    private val dataSourceModule =
        module {
            single<ShowDataSource> { ShowApiDataSource(get()) }
            single<DetailDataSource> { DetailApiDataSource(get()) }
        }
    private val repositoryModule =
        module {
            single<ShowRepository> { ShowRepositoryImpl(get()) }
            single<DetailRepository> { DetailRepositoryImpl(get()) }
        }
    private val viewModelModule =
        module {
            viewModel {
                HomeViewModel(get())
            }
            viewModel {
                DetailViewModel(get())
            }
        }
    val modules = listOf<Module>(
        networkModule, dataSourceModule, repositoryModule, viewModelModule

    )
}