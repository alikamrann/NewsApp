package com.example.newsapp.presentaion.di

import com.example.newsapp.data.db.ArticleDao
import com.example.newsapp.data.repository.dataSource.NewsLocalDatasource
import com.example.newsapp.data.repository.dataSource.dataSourceImpl.NewsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {

    @Singleton
    @Provides
    fun provideLocalDataSource(articleDao: ArticleDao):NewsLocalDatasource{
        return NewsLocalDataSourceImpl(articleDao)
    }
}