package com.example.maxtratechnologiestest.domain.usecases

import com.example.maxtratechnologiestest.data.Resource
import com.example.maxtratechnologiestest.data.model.PostListingRequest
import com.example.maxtratechnologiestest.data.model.PostListingResponse
import com.example.maxtratechnologiestest.domain.repository.Repository

class PostListingUseCases(private val repository: Repository) {
    suspend fun execute(postListingRequest: PostListingRequest) : Resource<PostListingResponse> =
        repository.postList(postListingRequest = postListingRequest)
}