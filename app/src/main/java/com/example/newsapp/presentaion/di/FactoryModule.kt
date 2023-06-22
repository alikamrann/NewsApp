package com.example.newsapp.presentaion.di

import android.app.Application
import com.example.newsapp.domain.usecase.DeleteSavedNewsUseCase
import com.example.newsapp.domain.usecase.GetNewsHeadlineUseCase
import com.example.newsapp.domain.usecase.GetSavedNewsUseCase
import com.example.newsapp.domain.usecase.GetSearchedNewsUseCase
import com.example.newsapp.domain.usecase.SaveNewsUseCase
import com.example.newsapp.presentaion.viewmodel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Provides
    @Singleton
    fun provideNewsViewModelFactory(
        application: Application,
        getNewsHeadlineUseCase: GetNewsHeadlineUseCase,
        getSearchedNewsUseCase: GetSearchedNewsUseCase,
        saveNewsUseCase: SaveNewsUseCase,
        getSavedNewsUseCase: GetSavedNewsUseCase,
        deleteSavedNewsUseCase: DeleteSavedNewsUseCase
    ):NewsViewModelFactory{
        return NewsViewModelFactory(
            application,
            getNewsHeadlineUseCase,
            getSearchedNewsUseCase,
            saveNewsUseCase,
            getSavedNewsUseCase,
            deleteSavedNewsUseCase
        )
    }
}