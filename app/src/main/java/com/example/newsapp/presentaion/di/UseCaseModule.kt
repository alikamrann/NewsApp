package com.example.newsapp.presentaion.di

import com.example.newsapp.domain.repository.NewsRepository
import com.example.newsapp.domain.usecase.GetNewsHeadlineUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideGetNewsHeadLinesUseCase(
        newsRepository: NewsRepository
    ): GetNewsHeadlineUseCase {
        return GetNewsHeadlineUseCase(newsRepository)
    }
}