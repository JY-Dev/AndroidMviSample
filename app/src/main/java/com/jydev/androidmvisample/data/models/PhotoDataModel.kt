package com.jydev.androidmvisample.data.models

data class PhotoDataModel(val id: String,
                          val width: Int,
                          val height: Int,
                          val description: String,
                          val altDescription: String,
                          val imageUrl: String?
)