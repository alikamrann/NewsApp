package com.example.newsapp.data.repository.dataSource.dataSourceImpl

import com.example.newsapp.data.api.NewsAPIService
import com.example.newsapp.data.model.APIResponse
import com.example.newsapp.data.repository.dataSource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsAPIService: NewsAPIService
):NewsRemoteDataSource {

    override suspend fun getTopHeadline(country: String, page: Int): Response<APIResponse> {
        return newsAPIService.getTopHeadline(country, page)
    }

    override suspend fun getSearchedNews(
        searchedQuery: String,
        page: Int
    ): Response<APIResponse> {
        return newsAPIService.getSearchedTopHeadline(searchedQuery,page)
    }
}