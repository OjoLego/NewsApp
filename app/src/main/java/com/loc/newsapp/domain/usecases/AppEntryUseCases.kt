package com.loc.newsapp.domain.usecases

/**
* Holds instances of use case classes to manage app entry status.
*/

data class AppEntryUseCases(
    val readAppEntry: ReadAppEntry,
    val saveAppEntry: SaveAppEntry
)
