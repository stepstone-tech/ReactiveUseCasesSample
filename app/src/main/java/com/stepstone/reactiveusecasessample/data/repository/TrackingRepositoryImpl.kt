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

import android.util.Log
import com.stepstone.reactiveusecasessample.domain.repository.TrackingRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TrackingRepositoryImpl
@Inject
constructor() : TrackingRepository {

    override fun trackSampleFeatureEnabled() {
        // Invoke an actual tracking library here instead
        Log.i("Tracking", "Sending a track action for custom feature enabled")
    }

    override fun trackSampleFeatureDisabled() {
        // Invoke an actual tracking library here instead
        Log.i("Tracking", "Sending a track action for custom feature disabled")
    }
}
