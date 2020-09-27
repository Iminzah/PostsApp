package com.example.postapp.viewmodels

import android.security.identity.AccessControlProfileId
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.postapp.models.Posts
import com.example.postapp.repository.PostsRepository
import kotlinx.coroutines.launch

class PostViewModel(val postsRepository: PostsRepository) : ViewModel() {
    var postsLiveData = MutableLiveData<List<Posts>>()
    var postsFailedLiveData = MutableLiveData<String>()

    fun getPosts() {
        viewModelScope.launch {
            val response = postsRepository.getPosts()
            if (response.isSuccessful) {
                postsLiveData.postValue(response.body())
            } else {
                postsFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }

    fun getDbPosts(){
        postsLiveData=postsRepository.getDbPosts()

    }

    fun getPostsById(postId:Int){
        postByIdLiveData= postsRepository.getPostById(postId)
    }
}