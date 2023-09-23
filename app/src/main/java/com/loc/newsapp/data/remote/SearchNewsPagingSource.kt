package com.loc.newsapp.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.loc.newsapp.data.remote.dto.NewsApi
import com.loc.newsapp.domain.model.Article

class SearchNewsPagingSource(
    private val newsApi: NewsApi,
    private val searchQuery: String,
    private val sources: String
): PagingSource<Int, Article>(){

    // Track the total number of news items loaded
    private var totalNewsCount = 0
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val page = params.key ?: 1
        return try {
            // Fetch news data from the API
            val newsResponse = newsApi.searchNews(searchQuery = searchQuery,sources = sources, page = page)

            // Update the total news count
            totalNewsCount += newsResponse.articles.size

            // Remove duplicates from the list of articles based on their titles
            val articles = newsResponse.articles.distinctBy { it.title }

            // Return a LoadResult.Page with loaded data and pagination information
            LoadResult.Page(
                data = articles,
                nextKey = if (totalNewsCount == newsResponse.totalResults) null else page + 1,
                prevKey = null
            )
        }catch (e:Exception){
            e.printStackTrace()

            // Return an error result if an exception is encountered
            LoadResult.Error(
                throwable = e
            )
        }
    }
}