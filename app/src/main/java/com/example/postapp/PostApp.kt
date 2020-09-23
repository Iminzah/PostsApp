package com.example.postapp

import android.app.Application
import android.content.Context

class PostApp:Application() {
    override fun onCreate() {
        super.onCreate()
    }
    companion object{
        lateinit var appContext:Context
    }
}