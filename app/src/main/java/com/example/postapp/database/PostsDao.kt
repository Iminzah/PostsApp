package com.example.postapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.OnConflictStrategy.*
import androidx.room.Query
import com.example.postapp.models.Posts
import androidx.room.OnConflictStrategy.REPLACE as OnConflictStrategyREPLACE

@Dao
interface PostsDao {
    @Insert(OnConflictStrategyREPLACE)
    fun insertPost(post: Posts)
    @Query(value = "SELECT * FROM Posts")
    fun getPosts() :liveData<list<Posts>>
    @Query(value:"SELECT * FROM posts WHERE id =:postId")
    fun getPostById(postId: Int):liveData<Posts>

    }
}