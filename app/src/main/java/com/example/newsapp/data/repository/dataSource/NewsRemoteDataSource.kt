package com.example.newsapp.data.repository.dataSource

import com.example.newsapp.data.model.APIResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getTopHeadline(country:String,page:Int):Response<APIResponse>
}