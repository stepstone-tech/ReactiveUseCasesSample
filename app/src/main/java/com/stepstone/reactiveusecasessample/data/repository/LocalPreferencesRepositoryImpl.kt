/*
 * Copyright (C) 2018 StepStone Services Sp. z o.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

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
