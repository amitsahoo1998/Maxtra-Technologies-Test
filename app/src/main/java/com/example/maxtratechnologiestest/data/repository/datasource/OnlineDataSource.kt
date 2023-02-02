package com.example.maxtratechnologiestest.data.repository.datasource

import com.example.maxtratechnologiestest.data.model.CreatePostRequest
import com.example.maxtratechnologiestest.data.model.CreatePostResponse
import com.example.maxtratechnologiestest.data.model.PostListingRequest
import com.example.maxtratechnologiestest.data.model.PostListingResponse
import retrofit2.Response

interface OnlineDataSource {
    suspend fun createPost(createPostRequest: CreatePostRequest): Response<CreatePostResponse>
    suspend fun postList(postListingRequest: PostListingRequest) : Response<PostListingResponse>
}