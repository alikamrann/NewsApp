package com.example.newsapp.domain.repository

import com.example.newsapp.data.model.APIResponse
import com.example.newsapp.data.model.Article
import com.example.newsapp.data.repository.dataSource.NewsLocalDatasource
import com.example.newsapp.data.repository.dataSource.NewsRemoteDataSource
import com.example.newsapp.data.util.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(
    private val newsRemoteDataSource: NewsRemoteDataSource,
    private val newsLocalDatasource: NewsLocalDatasource
):NewsRepository {
    override suspend fun getNewsHeadlines(country:String,page:Int): Resource<APIResponse> {
        return responseToResource(newsRemoteDataSource.getTopHeadline(country,page))
    }

    override suspend fun getSearchedNews(
        searchQuery: String,
        page: Int
    ): Resource<APIResponse> {
        return responseToResource(
            newsRemoteDataSource.getSearchedNews(searchQuery,page)
        )
    }

    private fun responseToResource(response:Response<APIResponse>):Resource<APIResponse>{
        if(response.isSuccessful){
            response.body()?.let {result->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }




    override suspend fun saveNews(article: Article) {
        newsLocalDatasource.saveArticleToDB(article)
    }

    override suspend fun deleteNews(article: Article) {
        newsLocalDatasource.deleteArticleFromDB(article)
    }

    override suspend fun getSavedNews(): Flow<List<Article>> {
        return newsLocalDatasource.getSavedArticles()
    }
}