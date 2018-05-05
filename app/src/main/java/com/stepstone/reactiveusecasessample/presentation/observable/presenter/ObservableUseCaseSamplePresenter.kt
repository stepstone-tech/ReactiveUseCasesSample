package com.stepstone.reactiveusecasessample.presentation.observable.presenter

import com.stepstone.reactiveusecasessample.domain.interactor.ReactToExternalChangesUseCase
import com.stepstone.reactiveusecasessample.internal.rx.EmptyObserver
import com.stepstone.reactiveusecasessample.presentation.observable.ObservableUseCaseSampleContract
import javax.inject.Inject

class ObservableUseCaseSamplePresenter
@Inject
constructor(private val reactToExternalChangesUseCase: ReactToExternalChangesUseCase) : ObservableUseCaseSampleContract.Presenter {

    private var view: ObservableUseCaseSampleContract.View? = null

    override fun attachView(mvpView: ObservableUseCaseSampleContract.View) {
        view = mvpView
    }

    override fun detachView() {
        view = null
        reactToExternalChangesUseCase.dispose()
    }

    override fun loadExternalEvents() {
        reactToExternalChangesUseCase.execute(observer = ExternalEventObserver())
    }

    private inner class ExternalEventObserver : EmptyObserver<String>() {

        override fun onNext(t: String) {
            view?.showExternalEvent(t)
        }
    }
}
