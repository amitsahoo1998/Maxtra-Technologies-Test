package com.example.maxtratechnologiestest.presenter.di

import com.example.maxtratechnologiestest.domain.repository.Repository
import com.example.maxtratechnologiestest.domain.usecases.CreatePostUseCases
import com.example.maxtratechnologiestest.domain.usecases.PostListingUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class UseCasesModule {
    @Singleton
    @Provides
    fun provideCreatePostUseCases(repository: Repository):CreatePostUseCases{
        return CreatePostUseCases(repository = repository)
    }

    @Singleton
    @Provides
    fun provideListPostUseCases(repository: Repository):PostListingUseCases{
        return PostListingUseCases(repository = repository)
    }
}