package com.stepstone.reactiveusecasessample.presentation.completable.presenter

import com.stepstone.reactiveusecasessample.domain.interactor.UploadContentUseCase
import com.stepstone.reactiveusecasessample.presentation.completable.CompletableUseCaseSampleContract
import io.reactivex.observers.DisposableCompletableObserver
import javax.inject.Inject

class CompletableUseCaseSamplePresenter
@Inject
constructor(private val uploadContentUseCase: UploadContentUseCase) : CompletableUseCaseSampleContract.Presenter {

    private var view: CompletableUseCaseSampleContract.View? = null

    override fun attachView(mvpView: CompletableUseCaseSampleContract.View) {
        view = mvpView
    }

    override fun detachView() {
        view = null
        uploadContentUseCase.dispose()
    }

    override fun uploadData() {
        view?.showProgress()
        uploadContentUseCase.execute(observer = UploadObserver())
    }

    private inner class UploadObserver : DisposableCompletableObserver() {

        override fun onComplete() {
            view?.showSuccess()
        }

        override fun onError(e: Throwable) {
            view?.showError()
        }
    }
}
