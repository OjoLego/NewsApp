package com.loc.newsapp.presentation.search

import androidx.paging.PagingData
import com.loc.newsapp.domain.model.Article

// A data class representing the state for the search feature.
data class SearchState(
    val searchQuery: String = "",
    val articles: kotlinx.coroutines.flow.Flow<PagingData<Article>>? = null
) {
}