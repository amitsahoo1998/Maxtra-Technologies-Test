package com.example.maxtratechnologiestest.presenter.di

import com.example.maxtratechnologiestest.data.api.ApiService
import com.example.maxtratechnologiestest.data.repository.datasource.OnlineDataSource
import com.example.maxtratechnologiestest.data.repository.datasourceimpl.OnlineDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class OnlineDataSourceModule {

    @Provides
    @Singleton
    fun provideOnlineDataSource(apiService: ApiService) : OnlineDataSource{
        return OnlineDataSourceImpl(apiService)
    }

}