package com.example.maxtratechnologiestest.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.maxtratechnologiestest.data.Resource
import com.example.maxtratechnologiestest.data.model.CreatePostRequest
import com.example.maxtratechnologiestest.data.model.CreatePostResponse
import com.example.maxtratechnologiestest.data.model.PostListingRequest
import com.example.maxtratechnologiestest.data.model.PostListingResponse
import com.example.maxtratechnologiestest.domain.usecases.CreatePostUseCases
import com.example.maxtratechnologiestest.domain.usecases.PostListingUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val createPostUseCases: CreatePostUseCases,
                    private val postListingUseCases: PostListingUseCases) : ViewModel(){
    val _createPostData : MutableLiveData<Resource<CreatePostResponse>> = MutableLiveData()
    val createPostResponse : LiveData<Resource<CreatePostResponse>>
    get() = _createPostData


    val _postListData : MutableLiveData<Resource<PostListingResponse>> = MutableLiveData()
    val postListData : LiveData<Resource<PostListingResponse>>
        get() = _postListData

    fun createPostApiCall(createPostRequest: CreatePostRequest)=
        viewModelScope.launch {
            _createPostData.postValue(createPostUseCases.execute(createPostRequest =createPostRequest))
        }

    fun getPostList(postListingRequest: PostListingRequest) =
        viewModelScope.launch {
            _postListData.postValue(postListingUseCases.execute(postListingRequest= postListingRequest))
        }

}