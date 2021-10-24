package com.jydev.androidmvisample.di

import com.jydev.androidmvisample.data.repository.PhotoRepository
import com.jydev.androidmvisample.domain.PhotosUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun providePhotoUseCase(repository: PhotoRepository) : PhotosUseCase =
        PhotosUseCase(repository)
}