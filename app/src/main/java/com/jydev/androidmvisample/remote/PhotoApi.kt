package com.jydev.androidmvisample.remote

import com.jydev.androidmvisample.remote.models.PhotosResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoApi {
    @GET("photos")
    fun getPhotos(
        @Query("page") page: Int?,
        @Query("per_page") perPage: Int?,
        @Query("order_by") orderBy: String?,
        @Query("client_id") clientId: String = "AnWwo5CtObz5iIy_GWI0Ge50YdEekidIx9x6riVowDI"
    ): Single<List<PhotosResponse>>
}