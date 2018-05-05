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
