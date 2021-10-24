package com.jydev.androidmvisample.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jydev.androidmvisample.domain.PhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.subjects.PublishSubject
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val useCase: PhotosUseCase) : ViewModel() {
    private val intentSubject: PublishSubject<MainIntent> =
        PublishSubject.create()
    private val _mainState = MutableLiveData<MainState>().apply {
        value = MainState.Idle
    }
    private val compositeDisposable = CompositeDisposable()
    val mainState = _mainState
    init {
        handleIntent()
    }

    fun sendIntent(mainIntent: MainIntent){
        intentSubject.onNext(mainIntent)
    }

    private fun handleIntent(){
        intentSubject.subscribe {
            when(it){
                is MainIntent.FetchPhotos -> getPhotos()
            }
        }
    }

    private fun getPhotos() {
        _mainState.value = MainState.Loading
        useCase(compositeDisposable) {
            when (it) {
                is PhotosUseCase.Result.Success -> {
                    _mainState.value = MainState.Photos(it.photos)
                }
                is PhotosUseCase.Result.Error -> {
                    _mainState.value = MainState.Error(it.message)
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}