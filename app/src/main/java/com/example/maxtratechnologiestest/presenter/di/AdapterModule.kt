package com.example.maxtratechnologiestest.presenter.di

import com.example.maxtratechnologiestest.presenter.adapter.PostAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AdapterModule {

    @Provides
    @Singleton
    fun providePostAdapter():PostAdapter{
        return PostAdapter()
    }
}