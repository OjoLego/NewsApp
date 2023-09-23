package com.loc.newsapp.domain.usecases.news

import androidx.paging.PagingData
import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

// Use case class responsible for searching news articles.
class SearchNews(
    private val newsRepository: NewsRepository
) {
    // This operator function is invoked to perform a news search.
    operator fun invoke(searchQuery: String,sources: List<String>): Flow<PagingData<Article>> {
        // Use the news repository to fetch paginated articles based on the search query and sources.
        return newsRepository.searchNews(searchQuery = searchQuery,sources = sources)
    }
}