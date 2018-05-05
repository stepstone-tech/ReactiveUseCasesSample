package com.stepstone.reactiveusecasessample.domain.interactor

import com.stepstone.reactiveusecasessample.domain.interactor.base.SynchronousUseCase
import com.stepstone.reactiveusecasessample.domain.repository.LocalPreferencesRepository
import com.stepstone.reactiveusecasessample.domain.repository.TrackingRepository
import javax.inject.Inject

class DisableSampleFeatureUseCase
@Inject
constructor(
    private val trackingRepository: TrackingRepository,
    private val localPreferencesRepository: LocalPreferencesRepository
) : SynchronousUseCase<Unit, Unit> {

    override fun execute(params: Unit?) {
        localPreferencesRepository.disableSampleFeature()
        trackingRepository.trackSampleFeatureDisabled()
    }
}
