package com.example.maxtratechnologiestest.domain.usecases

import com.example.maxtratechnologiestest.data.Resource
import com.example.maxtratechnologiestest.data.model.CreatePostRequest
import com.example.maxtratechnologiestest.data.model.CreatePostResponse
import com.example.maxtratechnologiestest.domain.repository.Repository

class CreatePostUseCases(private val repository: Repository) {
    suspend fun execute(createPostRequest: CreatePostRequest) : Resource<CreatePostResponse> =
        repository.createPost(createPostRequest = createPostRequest)
}