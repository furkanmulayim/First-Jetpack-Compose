package com.furkanmulayim.birikio.feature.screen_onboarding.data.local

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// DataStore instance
private val Context.dataStore by preferencesDataStore(name = "settings")

object OnboardingDataStore {
    private val ONBOARDING_KEY = booleanPreferencesKey("onboarding_completed")

    // data store okuma onboarding gösterildi mi?
    fun readOnboardingState(context: Context): Flow<Boolean> {
        return context.dataStore.data
            .map { preferences -> preferences[ONBOARDING_KEY] ?: false }
    }

    // data store yazma gösterildi olarak işaretle
    suspend fun saveOnboardingState(context: Context, completed: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[ONBOARDING_KEY] = completed
        }
    }
}