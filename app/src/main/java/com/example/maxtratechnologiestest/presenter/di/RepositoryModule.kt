package com.example.maxtratechnologiestest.presenter.di

import com.example.maxtratechnologiestest.data.repository.RepositoryImpl
import com.example.maxtratechnologiestest.data.repository.datasource.OnlineDataSource
import com.example.maxtratechnologiestest.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(onlineDataSource: OnlineDataSource):Repository{
        return RepositoryImpl(onlineDataSource = onlineDataSource)
    }

}