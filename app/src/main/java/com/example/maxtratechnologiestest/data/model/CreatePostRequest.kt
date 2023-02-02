package com.example.maxtratechnologiestest.data.model

data class CreatePostRequest(
    val discription: String,
    val images: List<String>,
    val name: String,
    val post_type: Int,
    val user_id: Int,
    val video_thumbnail: String,
    val videos: String
)