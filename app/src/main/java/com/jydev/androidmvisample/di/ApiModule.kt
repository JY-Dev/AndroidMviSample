package com.jydev.androidmvisample.di

import com.jydev.androidmvisample.remote.PhotoApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    @Singleton
    fun providePhotosApi(
        builder: Retrofit.Builder,
        okHttpClientBuilder: OkHttpClient.Builder
    ): PhotoApi =
        builder
            .baseUrl("https://api.unsplash.com/")
            .client(okHttpClientBuilder.build())
            .build()
            .create(PhotoApi::class.java)


}
