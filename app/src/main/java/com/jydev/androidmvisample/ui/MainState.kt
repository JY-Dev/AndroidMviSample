package com.jydev.androidmvisample.ui

import com.jydev.androidmvisample.domain.models.Photo

sealed class MainState{
    object Idle : MainState()
    object Loading : MainState()
    data class Photos(val photos : List<Photo>) : MainState()
    data class Error(val message : String) : MainState()
}
