package com.loc.newsapp.presentation.search


// Sealed class to represent events related to the search feature.
sealed class SearchEvents {

    // Data class to update the search query.
    data class UpdateSearchQuery(val searchQuery: String): SearchEvents()

    // Object to trigger a search for news articles.
    object SearchNews: SearchEvents()

}