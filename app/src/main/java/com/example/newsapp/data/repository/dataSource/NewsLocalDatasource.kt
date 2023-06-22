package com.example.newsapp.data.repository.dataSource

import com.example.newsapp.data.model.Article

interface NewsLocalDatasource {
    suspend fun saveArticleToDB(article: Article)
}