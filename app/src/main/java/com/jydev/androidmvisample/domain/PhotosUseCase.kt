package com.jydev.androidmvisample.domain

import com.jydev.androidmvisample.data.repository.PhotoRepository
import com.jydev.androidmvisample.domain.models.Photo
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class PhotosUseCase @Inject constructor(private val repository: PhotoRepository) {
    operator fun invoke(
        compositeDisposable: CompositeDisposable,
        observeOn: Scheduler = AndroidSchedulers.mainThread(),
        subscribeOn: Scheduler = Schedulers.io(),
        result: (Result) -> Unit
    ) {
        compositeDisposable.add(repository.getPhotos(0, 10, "popular").subscribeOn(subscribeOn)
            .observeOn(observeOn)
            .subscribe({
                result(Result.Success(it.map { dataModel ->
                    with(dataModel) {
                        Photo(id, width, height, description, altDescription, imageUrl)
                    }
                }))
            }, {
                result(Result.Error(it.message ?: "Error"))
            }))
    }


    sealed class Result {
        data class Success(val photos: List<Photo>) : Result()
        data class Error(val message: String) : Result()
    }

}