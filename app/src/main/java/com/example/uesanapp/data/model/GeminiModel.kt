package com.example.uesanapp.data.model

data class Part(
    val text: String
)

data class Content(
    val parts: List<Part>
)

//Gemini request
data class GeminiRequest(
    val parts: List<Content>
)

data class Candidate(
    val content: Content

)

data class GeminiResponse(
    val candidate: List<Candidate>
)
