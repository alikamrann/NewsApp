package com.example.newsapp.domain.repository

import com.example.newsapp.data.model.APIResponse
import com.example.newsapp.data.model.Article
import com.example.newsapp.data.repository.dataSource.NewsRemoteDataSource
import com.example.newsapp.data.util.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(private val newsRemoteDataSource: NewsRemoteDataSource):NewsRepository {
    override suspend fun getNewsHeadlines(): Resource<APIResponse> {
        return responseToResource(newsRemoteDataSource.getTopHeadline())
    }
    private fun responseToResource(response: Response<APIResponse>):Resource<APIResponse>{
        if(response.isSuccessful){
            response.body()?.let {result->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())

    }

    override suspend fun getSearchedNews(searchQuery: String): Resource<APIResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun saveNews(article: Article) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNews(article: Article) {
        TODO("Not yet implemented")
    }

    override suspend fun getSavedNews(): Flow<List<Article>> {
        TODO("Not yet implemented")
    }
}