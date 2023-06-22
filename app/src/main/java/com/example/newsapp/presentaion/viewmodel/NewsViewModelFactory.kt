package com.example.newsapp.presentaion.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.domain.usecase.DeleteSavedNewsUseCase
import com.example.newsapp.domain.usecase.GetNewsHeadlineUseCase
import com.example.newsapp.domain.usecase.GetSavedNewsUseCase
import com.example.newsapp.domain.usecase.GetSearchedNewsUseCase
import com.example.newsapp.domain.usecase.SaveNewsUseCase

class NewsViewModelFactory(
    private val app: Application,
    private val getNewsHeadlinesUseCase: GetNewsHeadlineUseCase,
    private val getSearchedNewsUseCase: GetSearchedNewsUseCase,
    private val savedNewsUseCase: SaveNewsUseCase,
    private val getSavedNewsUseCase: GetSavedNewsUseCase,
    private val deleteSavedNewsUseCase: DeleteSavedNewsUseCase
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(
            app,
            getNewsHeadlinesUseCase,
            getSearchedNewsUseCase,
            savedNewsUseCase,
            getSavedNewsUseCase,
            deleteSavedNewsUseCase
        )as T
    }
}