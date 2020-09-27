package com.example.postapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.postapp.R
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.postsapp.repository.CommentsRepository
import com.example.postsapp.viewmodel.CommentsViewModel
import com.example.postsapp.viewmodel.CommentsViewModelFactory
import kotlinx.android.synthetic.main.activity_comment.*

class CommentActivity : AppCompatActivity() {
    lateinit var commentsViewModel: CommentsViewModel
    lateinit var commentsViewModelFactory: CommentsViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)

        val commentsRepository= CommentsRepository()
        commentsViewModelFactory= CommentsViewModelFactory(commentsRepository)
        commentsViewModel=
            ViewModelProvider(this, commentsViewModelFactory).get(CommentsViewModel::class.java)

        commentsViewModel.getPosts()

        commentsViewModel.commentsLiveData.observe(this, Observe { commentsList->
            rvComments.apply{
                layoutManager= LinearLayoutManager(this@CommentsActivity)
                hasFixedSize()
                adapter=CommentsAdapter(commentsList)
            }
            Toast.makeText(baseContext,"${commentsList.size} comments fetched", Toast.LENGTH_LONG).show()
        })
        commentsViewModel.commentsFailedLiveData.observe(this, Observe { error->
            Toast.makeText(baseContext,error, Toast.LENGTH_LONG).show()
        })

    }
}

class CommentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)
        postId = intent.getIntExtra(name: "POST_ID",de)
}