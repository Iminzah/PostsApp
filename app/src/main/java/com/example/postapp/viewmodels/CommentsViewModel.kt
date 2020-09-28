package com.example.postapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class CommentsViewModel(val commentsRepository: CommentsRepository): ViewModeldel() {
    lateinit var commentsLiveData:LiveData<List<Comments>>
    var commentsFailedLiveData=MutableliveData<String>()

    fun getAPiComments(postId:Int){
        viewModelScope.launch{
            val response=commentsRepository.getComments(postId)
            if(response.isSuccesful){
                commentsLiveData.postValue(response.body() as List<Comments>)
            }

        }
    }
}