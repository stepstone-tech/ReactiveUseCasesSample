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
