package com.loc.newsapp.domain.manager

import kotlinx.coroutines.flow.Flow

/**
 * Interface for a local user manager responsible for handling user-related data.
 */
interface LocalUserManager {

    /**
     * Saves the user's app entry status.
     */
    suspend fun saveAppEntry()

    /**
     * Reads the user's app entry status as a Flow of Boolean values.
     */
    fun readAppEntry(): Flow<Boolean>

}