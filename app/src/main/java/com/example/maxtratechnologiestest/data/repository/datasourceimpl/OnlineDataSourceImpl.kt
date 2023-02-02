package com.example.maxtratechnologiestest.data.repository.datasourceimpl

import com.example.maxtratechnologiestest.data.api.ApiService
import com.example.maxtratechnologiestest.data.model.CreatePostRequest
import com.example.maxtratechnologiestest.data.model.CreatePostResponse
import com.example.maxtratechnologiestest.data.model.PostListingRequest
import com.example.maxtratechnologiestest.data.model.PostListingResponse
import com.example.maxtratechnologiestest.data.repository.datasource.OnlineDataSource
import retrofit2.Response

class OnlineDataSourceImpl(private val apiService: ApiService) : OnlineDataSource {
    override suspend fun createPost(createPostRequest: CreatePostRequest): Response<CreatePostResponse> {
        return apiService.createPostApiCall(createPostRequest = createPostRequest)
    }

    override suspend fun postList(postListingRequest: PostListingRequest): Response<PostListingResponse> {
        return apiService.postListingApiCall(postListingRequest = postListingRequest)
    }
}