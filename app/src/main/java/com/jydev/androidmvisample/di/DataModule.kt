package com.jydev.androidmvisample.di

import com.jydev.androidmvisample.data.repository.PhotoRepository
import com.jydev.androidmvisample.remote.PhotoApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun providePhotoRepository(api: PhotoApi) : PhotoRepository =
        PhotoRepository(api)

}