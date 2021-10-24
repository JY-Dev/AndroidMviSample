package com.jydev.androidmvisample.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.jydev.androidmvisample.databinding.ItemPhotoBinding
import com.jydev.androidmvisample.domain.models.Photo

class PhotoViewHolder(private val binding : ItemPhotoBinding , private val glide : RequestManager) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item : Photo){
        binding.photoDescriptionTextView.text = item.description
        glide.load(item.imageUrl)
            .into(binding.photoImageView)
    }
}