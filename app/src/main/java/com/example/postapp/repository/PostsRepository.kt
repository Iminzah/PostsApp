package com.example.postapp.repository

import com.example.postapp.models.Posts
import com.example.postapp.api.ApiClient
import com.example.postapp.api.ApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.withContext
import retrofit2.Response

class PostsRepository() {
    suspend fun getPosts(): Response<List<Posts>> = withContext(Dispatchers.IO + NonCancellable) {
        val apiClient = ApiClient.buildService(ApiInterface::class.java)
        val response = apiClient.getPosts()
        return@withContext response
    }
}