package com.example.maxtratechnologiestest.data.repository

import com.example.maxtratechnologiestest.data.Resource
import com.example.maxtratechnologiestest.data.model.CreatePostRequest
import com.example.maxtratechnologiestest.data.model.CreatePostResponse
import com.example.maxtratechnologiestest.data.model.PostListingRequest
import com.example.maxtratechnologiestest.data.model.PostListingResponse
import com.example.maxtratechnologiestest.data.repository.datasource.OnlineDataSource
import com.example.maxtratechnologiestest.domain.repository.Repository
import retrofit2.Response

class RepositoryImpl(private val onlineDataSource: OnlineDataSource) :Repository{

    private fun responseToResourceCreatePost(response : Response<CreatePostResponse>): Resource<CreatePostResponse> {
        if (response.isSuccessful){
            response.body()?.let {result->
                return Resource.Success(result);
            }
        }
        return Resource.Error(response.message())
    }

    private fun responseToResourceListPost(response : Response<PostListingResponse>): Resource<PostListingResponse> {
        if (response.isSuccessful){
            response.body()?.let {result->
                return Resource.Success(result);
            }
        }
        return Resource.Error(response.message())
    }

    override suspend fun createPost(createPostRequest: CreatePostRequest): Resource<CreatePostResponse> {
        return responseToResourceCreatePost(response = onlineDataSource.createPost(createPostRequest = createPostRequest))
    }

    override suspend fun postList(postListingRequest: PostListingRequest): Resource<PostListingResponse> {
        return responseToResourceListPost(response = onlineDataSource.postList(postListingRequest = postListingRequest))
    }

}