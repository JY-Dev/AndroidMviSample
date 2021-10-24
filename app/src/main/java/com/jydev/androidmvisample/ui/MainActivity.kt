package com.jydev.androidmvisample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.jydev.androidmvisample.databinding.ActivityMainBinding
import com.jydev.androidmvisample.ui.adapter.PhotoAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainViewModel : MainViewModel by viewModels()
    private lateinit var binding : ActivityMainBinding
    private val photoAdapter : PhotoAdapter by lazy {
        PhotoAdapter(Glide.with(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        observeState()
        mainViewModel.sendIntent(MainIntent.FetchPhotos)
    }

    private fun initView() = with(binding){
        recyclerView.adapter = photoAdapter
    }

    private fun observeState(){
        mainViewModel.mainState.observe(this){ mainState ->
            when(mainState){
                is MainState.Loading -> {
                    setProgressStatus(isProgressShow = true)
                }
                is MainState.Photos -> {
                    setProgressStatus()
                    photoAdapter.submitList(mainState.photos)
                }
                is MainState.Error -> {
                    setProgressStatus()
                    Toast.makeText(this,"에러내용 : ${mainState.message}",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun setProgressStatus(isProgressShow : Boolean = false){
        var visibility = View.GONE
        if(isProgressShow)
            visibility = View.VISIBLE
        binding.progress.visibility = visibility
    }
}