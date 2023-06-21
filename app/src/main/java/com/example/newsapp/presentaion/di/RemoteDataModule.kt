package com.example.newsapp.presentaion.di

import com.example.newsapp.data.api.NewsAPIService
import com.example.newsapp.data.repository.dataSource.NewsRemoteDataSource
import com.example.newsapp.data.repository.dataSource.dataSourceImpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideNewsRemoteDataSource(
        newsAPIService: NewsAPIService
    ):NewsRemoteDataSource{
        return NewsRemoteDataSourceImpl(newsAPIService)
    }
}