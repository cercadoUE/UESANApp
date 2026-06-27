package com.example.uesanapp.data.remote.gemini

import com.example.uesanapp.data.model.GeminiRequest
import com.example.uesanapp.data.model.GeminiResponse
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface GeminiApiService {

    @POST("/v1beta/interactions")
    suspend fun generateContent(
        @Query("key") apiKey: String,
        @Body request: GeminiRequest
    ): GeminiResponse


}
