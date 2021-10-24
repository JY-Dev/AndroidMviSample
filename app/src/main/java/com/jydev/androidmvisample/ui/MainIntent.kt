package com.jydev.androidmvisample.ui

sealed class MainIntent {
    object FetchPhotos : MainIntent()
}