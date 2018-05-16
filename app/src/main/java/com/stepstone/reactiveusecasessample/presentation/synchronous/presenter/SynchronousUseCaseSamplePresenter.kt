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
