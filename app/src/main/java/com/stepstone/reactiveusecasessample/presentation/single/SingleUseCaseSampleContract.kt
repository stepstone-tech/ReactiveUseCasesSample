package com.stepstone.reactiveusecasessample.presentation.single

import com.stepstone.reactiveusecasessample.domain.model.Content

interface SingleUseCaseSampleContract {

    interface View {

        fun showContent(content: Content)

        fun showProgress()

        fun showError()
    }

    interface Presenter {

        fun attachView(mvpView: View)

        fun detachView()

        fun loadContent()
    }
}
