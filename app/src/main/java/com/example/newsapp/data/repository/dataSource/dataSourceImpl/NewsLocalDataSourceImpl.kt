package com.example.newsapp.data.repository.dataSource.dataSourceImpl

import com.example.newsapp.data.db.ArticleDao
import com.example.newsapp.data.model.Article
import com.example.newsapp.data.repository.dataSource.NewsLocalDatasource

class NewsLocalDataSourceImpl(
    private val articleDao: ArticleDao
) : NewsLocalDatasource {
    override suspend fun saveArticleToDB(article: Article) {
        articleDao.insert(article)
    }
}