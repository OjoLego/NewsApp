package com.loc.newsapp.presentation.search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.loc.newsapp.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

// This ViewModel manages the state and logic for the search feature.
@HiltViewModel
class SearchViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
): ViewModel() {

    private val _state = mutableStateOf(SearchState())
    val state: State<SearchState> = _state

    // Function to handle various search-related events.
    fun onEvent(events: SearchEvents){
        when(events){
            // When a search query is updated, update the search state.
            is SearchEvents.UpdateSearchQuery -> {
                _state.value = state.value.copy(searchQuery = events.searchQuery)
            }
            // When a search for news is requested, trigger the search.
            is SearchEvents.SearchNews -> {
                searchNews()
            }
        }
    }

    // Private function to perform the actual news search.
    private fun searchNews() {
        // Use the news use case to fetch articles based on the search query and sources.
        val articles = newsUseCases.searchNews(
            searchQuery = state.value.searchQuery,
            sources = listOf("bbc-news", "abc-news", "al-jazeera-news")
        ).cachedIn(viewModelScope)
        // Update the search state with the retrieved articles.
        _state.value = state.value.copy(articles = articles)
    }
}