package com.stepstone.reactiveusecasessample.domain.repository

interface LocalPreferencesRepository {

    fun enableSampleFeature()

    fun disableSampleFeature()

    fun isSampleFeatureEnabled(): Boolean
}
