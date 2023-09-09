package com.loc.newsapp.presentation.navgraph

/**
 * Contains a sealed class called "Route" that represents different navigation routes
 * within the NewsApp's navigation graph.
 */
sealed class Route(
    val route: String
){
    object OnBoardingScreen: Route(route = "onBoardingScreen")
    object HomeScreen: Route(route = "homeScreen")
    object SearchScreen: Route(route = "searchScreen")
    object BookmarkScreen: Route(route = "bookmarkScreen")
    object DetailsScreen: Route(route = "detailsScreen")
    object AppStartNavigation: Route(route = "appStartNavigation")
    object NewsNavigation: Route(route = "newsNavigation")
    object NewsNavigationScreen: Route(route = "newsNavigationScreen")

}
