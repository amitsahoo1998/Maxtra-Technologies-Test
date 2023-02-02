package com.example.maxtratechnologiestest.domain.repository

import com.example.maxtratechnologiestest.data.Resource
import com.example.maxtratechnologiestest.data.model.CreatePostRequest
import com.example.maxtratechnologiestest.data.model.CreatePostResponse
import com.example.maxtratechnologiestest.data.model.PostListingRequest
import com.example.maxtratechnologiestest.data.model.PostListingResponse
import retrofit2.Response

interface Repository {
    suspend fun createPost(createPostRequest: CreatePostRequest): Resource<CreatePostResponse>
    suspend fun postList(postListingRequest: PostListingRequest) : Resource<PostListingResponse>
}