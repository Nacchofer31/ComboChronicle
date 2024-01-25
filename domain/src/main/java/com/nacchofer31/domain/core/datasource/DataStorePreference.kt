package com.nacchofer31.domain.core.datasource

import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.Flow

interface DataStorePreference {

    suspend fun <T> getData(key: Preferences.Key<T>, defaultValue: T): Flow<T>
    suspend fun <T> setData(key: Preferences.Key<T>, value: T)
    suspend fun <T> setSecuredData(key: Preferences.Key<String>, value: T)
    suspend fun <T> getSecuredData(key: Preferences.Key<String>, type: Class<T>): Flow<T>
}