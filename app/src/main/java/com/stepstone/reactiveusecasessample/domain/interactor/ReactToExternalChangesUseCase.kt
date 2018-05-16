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

package com.stepstone.reactiveusecasessample.domain.interactor

import com.stepstone.reactiveusecasessample.domain.executor.PostExecutionThread
import com.stepstone.reactiveusecasessample.domain.executor.ThreadExecutor
import com.stepstone.reactiveusecasessample.domain.interactor.base.ObservableUseCase
import com.stepstone.reactiveusecasessample.domain.service.ExternalChangeListener
import io.reactivex.Observable
import javax.inject.Inject

class ReactToExternalChangesUseCase
@Inject
constructor(
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
    private val externalChangeListener: ExternalChangeListener
) : ObservableUseCase<String, Unit>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params: Unit?): Observable<String> {
        return externalChangeListener.onFavouriteChangeEvent()
                .map { it.name }
    }

    override fun dispose() {
        super.dispose()
        externalChangeListener.dispose()
    }
}
