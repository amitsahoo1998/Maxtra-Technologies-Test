package com.example.maxtratechnologiestest.data.api

import com.example.maxtratechnologiestest.data.model.CreatePostRequest
import com.example.maxtratechnologiestest.data.model.CreatePostResponse
import com.example.maxtratechnologiestest.data.model.PostListingRequest
import com.example.maxtratechnologiestest.data.model.PostListingResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("create_post")
    suspend fun createPostApiCall(
        @Body createPostRequest: CreatePostRequest
    ): Response<CreatePostResponse>

    @POST("post_listing")
    suspend fun postListingApiCall(
        @Body postListingRequest: PostListingRequest
    ): Response<PostListingResponse>

}