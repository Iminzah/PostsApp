package com.example.postapp.database

import androidx.room.Database
import com.example.postapp.models.Posts


@Database(entities = arrayOf(Posts::class,version=1)

 abstract class PostsAppDatabase {
 abstract  fun PostsDao():PostsDao
}