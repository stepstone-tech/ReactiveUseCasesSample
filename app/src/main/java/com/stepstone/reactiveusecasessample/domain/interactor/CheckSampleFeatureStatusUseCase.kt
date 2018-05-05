package com.stepstone.reactiveusecasessample.domain.interactor

import com.stepstone.reactiveusecasessample.domain.interactor.base.SynchronousUseCase
import com.stepstone.reactiveusecasessample.domain.repository.LocalPreferencesRepository
import javax.inject.Inject

class CheckSampleFeatureStatusUseCase
@Inject
constructor(
    private val localPreferencesRepository: LocalPreferencesRepository
) : SynchronousUseCase<Boolean, Unit> {

    override fun execute(params: Unit?): Boolean =
        localPreferencesRepository.isSampleFeatureEnabled()
}
