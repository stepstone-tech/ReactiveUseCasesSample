package com.stepstone.reactiveusecasessample.presentation.synchronous

interface SynchronousUseCaseSampleContract {

    interface View {

        fun setToggleStatus(enabled: Boolean)
    }

    interface Presenter {

        fun attachView(mvpView: View)

        fun detachView()

        fun toggleSampleFeature(enabled: Boolean)
    }
}
