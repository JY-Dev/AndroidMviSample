package com.jydev.androidmvisample.data.repository

import com.jydev.androidmvisample.data.models.PhotoDataModel
import com.jydev.androidmvisample.remote.PhotoApi
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class PhotoRepository @Inject constructor(private val api : PhotoApi) {
    fun getPhotos(page : Int, perPage : Int, orderBy : String) : Single<List<PhotoDataModel>> =
        api.getPhotos(page, perPage, orderBy).map {
            it.map { response ->
                with(response){
                    PhotoDataModel(id,width,height,description?:"",altDescription?:"", urls.thumb)
                }
            }
        }

}