/*
 * Copyright (C) 2018 StepStone Services Sp. z o.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

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
