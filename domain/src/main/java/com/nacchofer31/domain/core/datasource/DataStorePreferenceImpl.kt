package com.nacchofer31.domain.core.datasource

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.MutablePreferences
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.nacchofer31.domain.exception.InternalError
import com.nacchofer31.domain.core.di.security.SecurityManager
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataStorePreferenceImpl @Inject constructor(
    val dataStore: DataStore<Preferences>,
    val gson: Gson,
    val securityManager: SecurityManager
) : DataStorePreference {

    override suspend fun <T> getData(key: Preferences.Key<T>, defaultValue: T): Flow<T> {
        return dataStore.data
            .catch { throw InternalError.DataStoreError }
            .map { preferences ->
                preferences[key] ?: defaultValue
            }
    }

    override suspend fun <T> setData(key: Preferences.Key<T>, value: T) {
        dataStore.edit {
            it[key] = value
        }
    }

    override suspend fun <T> setSecuredData(key: Preferences.Key<String>, value: T) {
        dataStore.secureEdit(gson.toJson(value)) { prefs, encryptedValue ->
            prefs[key] = encryptedValue
        }
    }

    override suspend fun <T> getSecuredData(key: Preferences.Key<String>, type: Class<T>): Flow<T> {
        return dataStore.data
            .secureMap(type) { prefs ->  prefs[key] }
            .catch { throw InternalError.DataStoreError }
    }

    inline fun <T> Flow<Preferences>.secureMap(type: Class<T>, crossinline fetchValue: (value: Preferences) -> String?): Flow<T> {
        return map { preference ->
            val decryptedValue = securityManager.decryptData(
                fetchValue(preference)?.map {
                    it
                }.toString()
            )
            gson.fromJson(decryptedValue, type)
        }
    }

    private suspend inline fun DataStore<Preferences>.secureEdit(
        value: String,
        crossinline editStore: (MutablePreferences, String) -> Unit
    ) {
        edit {
            val encryptedValue = securityManager.encryptData(value)
            editStore.invoke(it, encryptedValue)
        }
    }
}