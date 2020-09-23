package com.example.postapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.postapp.models.Posts

@Dao
interface PostsDao {
    @Insert(OnConflictStrategy.REPLACE)
    fun insertPost(post: Posts)
    @Query(value = "SELECT * FROM Posts")
    fun getPosts() :liveData<list<Posts>>
}