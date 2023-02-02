package com.example.maxtratechnologiestest.presenter.di

import android.content.Context
import com.example.maxtratechnologiestest.BuildConfig
import com.example.maxtratechnologiestest.data.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun createOkHttpClient(@ApplicationContext context: Context): OkHttpClient {
        val cacheSize: Long = 10 * 1024 * 1024 // 10 MB
        val cache = Cache(context.cacheDir, cacheSize)

        val client = OkHttpClient.Builder()
            .cache(cache) //To use cache
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            client.addNetworkInterceptor(interceptor)
        }

        client.addNetworkInterceptor { chain ->
            val request = chain.request().newBuilder().build()
            chain.proceed(request)
        }.build()

        return client.build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    @Singleton
    @Provides
    fun provideNewsService(retrofit: Retrofit) : ApiService {
        return retrofit.create(ApiService::class.java)
    }
}