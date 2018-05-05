package com.stepstone.reactiveusecasessample.presentation.synchronous.presenter

import com.stepstone.reactiveusecasessample.domain.interactor.CheckSampleFeatureStatusUseCase
import com.stepstone.reactiveusecasessample.domain.interactor.DisableSampleFeatureUseCase
import com.stepstone.reactiveusecasessample.domain.interactor.EnableSampleFeatureUseCase
import com.stepstone.reactiveusecasessample.presentation.synchronous.SynchronousUseCaseSampleContract
import javax.inject.Inject

class SynchronousUseCaseSamplePresenter
@Inject
constructor(
    private val enableSampleFeatureUseCase: EnableSampleFeatureUseCase,
    private val disableSampleFeatureUseCase: DisableSampleFeatureUseCase,
    private val checkSampleFeatureStatusUseCase: CheckSampleFeatureStatusUseCase
) : SynchronousUseCaseSampleContract.Presenter {

    private var view: SynchronousUseCaseSampleContract.View? = null

    override fun attachView(mvpView: SynchronousUseCaseSampleContract.View) {
        view = mvpView
        view?.setToggleStatus(checkSampleFeatureStatusUseCase.execute())
    }

    override fun detachView() {
        view = null
    }

    override fun toggleSampleFeature(enabled: Boolean) {
        if (enabled) {
            enableSampleFeatureUseCase.execute()
        } else {
            disableSampleFeatureUseCase.execute()
        }
    }
}
