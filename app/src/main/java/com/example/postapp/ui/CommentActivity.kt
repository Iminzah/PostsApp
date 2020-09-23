package com.example.postapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.postapp.R

class CommentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)
        postId = intent.getIntExtra(name: "POST_ID",de)
}