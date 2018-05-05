package com.stepstone.reactiveusecasessample.presentation.single.presenter

import com.stepstone.reactiveusecasessample.domain.interactor.LoadContentUseCase
import com.stepstone.reactiveusecasessample.domain.model.Content
import com.stepstone.reactiveusecasessample.presentation.single.SingleUseCaseSampleContract
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class SingleUseCaseSamplePresenter
@Inject
constructor(private val loadContentUseCase: LoadContentUseCase) : SingleUseCaseSampleContract.Presenter {

    private var view: SingleUseCaseSampleContract.View? = null

    override fun attachView(mvpView: SingleUseCaseSampleContract.View) {
        view = mvpView
    }

    override fun detachView() {
        view = null
        loadContentUseCase.dispose()
    }

    override fun loadContent() {
        view?.showProgress()
        loadContentUseCase.execute(observer = ContentObserver())
    }

    private inner class ContentObserver : DisposableSingleObserver<Content>() {

        override fun onSuccess(t: Content) {
            view?.showContent(t)
        }

        override fun onError(e: Throwable) {
            view?.showError()
        }
    }
}
