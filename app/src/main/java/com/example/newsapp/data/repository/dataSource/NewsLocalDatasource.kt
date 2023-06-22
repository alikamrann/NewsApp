package com.example.newsapp.data.repository.dataSource

import com.example.newsapp.data.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsLocalDatasource {
    suspend fun saveArticleToDB(article: Article)

    fun getSavedArticles() : Flow<List<Article>>

    suspend fun deleteArticleFromDB(article: Article)
}