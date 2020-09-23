package com.example.postapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.postapp.repository.PostsRepository
import com.example.postapp.viewmodels.PostViewModel
import java.lang.IllegalArgumentException

class PostsViewModelFactory(private val postsRepository: PostsRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostViewModel::class.java)){
            return PostViewModel(postsRepository) as T
        }
        throw IllegalArgumentException("Unknown Viewmodel class")
    }
}
