package com.example.uesanapp.presentation.chat

import androidx.lifecycle.ViewModel
import com.example.uesanapp.data.remote.gemini.GeminiApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class GeminiViewModel : ViewModel() {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.gemini.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val api = retrofit.create(GeminiApiService::class.java)
}