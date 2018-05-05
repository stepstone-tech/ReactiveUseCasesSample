package com.stepstone.reactiveusecasessample.presentation.observable

interface ObservableUseCaseSampleContract {

    interface View {

        fun showExternalEvent(eventName: String)
    }

    interface Presenter {

        fun attachView(mvpView: View)

        fun detachView()

        fun loadExternalEvents()
    }
}
