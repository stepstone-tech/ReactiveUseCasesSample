package com.stepstone.reactiveusecasessample.data.repository

import android.app.Application
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.stepstone.reactiveusecasessample.domain.repository.LocalPreferencesRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalPreferencesRepositoryImpl
@Inject
constructor(private val application: Application) : LocalPreferencesRepository {

    companion object {
        private const val SAMPLE_FEATURE_KEY = "sampleFeature"
    }

    private val sharedPreferences: SharedPreferences by lazy {
        PreferenceManager.getDefaultSharedPreferences(
            application
        )
    }

    override fun enableSampleFeature() {
        sharedPreferences.edit()
            .putBoolean(SAMPLE_FEATURE_KEY, true)
            .apply()
    }

    override fun disableSampleFeature() {
        sharedPreferences.edit()
            .putBoolean(SAMPLE_FEATURE_KEY, false)
            .apply()
    }

    override fun isSampleFeatureEnabled(): Boolean =
        sharedPreferences.getBoolean(SAMPLE_FEATURE_KEY, false)
}
