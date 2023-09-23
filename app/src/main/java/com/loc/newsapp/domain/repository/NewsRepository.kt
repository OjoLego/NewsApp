package com.loc.newsapp.domain.repository

import androidx.paging.PagingData
import com.loc.newsapp.domain.model.Article

interface NewsRepository {

    fun getNews(sources: List<String>): kotlinx.coroutines.flow.Flow<PagingData<Article>>

    fun searchNews(searchQuery: String,sources: List<String>): kotlinx.coroutines.flow.Flow<PagingData<Article>>

}