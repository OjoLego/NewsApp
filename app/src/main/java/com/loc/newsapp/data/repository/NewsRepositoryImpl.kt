package com.loc.newsapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.loc.newsapp.data.remote.NewsPagingSource
import com.loc.newsapp.data.remote.dto.NewsApi
import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

// Implementing the NewsRepository interface
class NewsRepositoryImpl(
    private val newsApi: NewsApi
): NewsRepository {

    // Implements the getNews function to retrieve news data as a Flow of PagingData
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {

        // Pager to handle paging of news data
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(
                    newsApi = newsApi,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }

}