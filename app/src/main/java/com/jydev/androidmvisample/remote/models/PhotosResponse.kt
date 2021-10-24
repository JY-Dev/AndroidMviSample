/*
 * Created by Lee Oh Hyung on 2020/09/19.
 */
package com.jydev.androidmvisample.remote.models

import com.google.gson.annotations.SerializedName

data class PhotosResponse(
    val id: String,
    val width: Int,
    val height: Int,
    val color: String,
    val description: String?,
    @SerializedName("alt_description")
    val altDescription: String?,
    val urls: UrlsResponse
)
