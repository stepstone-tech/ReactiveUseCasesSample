package com.stepstone.reactiveusecasessample.presentation.completable

interface CompletableUseCaseSampleContract {

    interface View {

        fun showSuccess()

        fun showProgress()

        fun showError()
    }

    interface Presenter {

        fun attachView(mvpView: View)

        fun detachView()

        fun uploadData()
    }
}
