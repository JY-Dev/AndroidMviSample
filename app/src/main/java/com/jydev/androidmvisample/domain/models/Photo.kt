package com.jydev.androidmvisample.domain.models

data class Photo(val id: String,
                 val width: Int,
                 val height: Int,
                 val description: String,
                 val altDescription: String,
                 val imageUrl: String?)