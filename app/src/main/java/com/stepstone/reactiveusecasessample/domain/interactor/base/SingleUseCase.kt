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

package com.stepstone.reactiveusecasessample.domain.interactor.base

import com.stepstone.reactiveusecasessample.internal.rx.EmptySingleObserver
import com.stepstone.reactiveusecasessample.domain.executor.PostExecutionThread
import com.stepstone.reactiveusecasessample.domain.executor.ThreadExecutor
import io.reactivex.Single
import io.reactivex.observers.DisposableSingleObserver

/**
 * Abstract class for a Use Case (Interactor in terms of Clean Architecture).
 * This interface represents a execution unit for different use cases (this means any use case
 * in the application should implement this contract).
 *
 * By convention each UseCase implementation will return the result using a [DisposableSingleObserver]
 * that will execute its job in a background thread and will post the result in the UI thread.
 *
 * This use case is to be used when we expect a single value to be emitted via a [Single].
 */
abstract class SingleUseCase<Results, in Params>(
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : BaseReactiveUseCase(threadExecutor, postExecutionThread) {

    /**
     * Builds an [Single] which will be used when executing the current [SingleUseCase].
     */
    abstract fun buildUseCaseSingle(params: Params? = null): Single<Results>

    /**
     * Executes the current use case.
     *
     * @param observer [DisposableSingleObserver] which will be listening to the observer build
     * by [buildUseCaseSingle] method.
     * @param params Parameters (Optional) used to build/execute this use case.
     */
    fun execute(observer: DisposableSingleObserver<Results> = EmptySingleObserver(), params: Params? = null) {
        val single = buildUseCaseSingleWithSchedulers(params)
        addDisposable(single.subscribeWith(observer))
    }

    /**
     * Builds a [Single] which will be used when executing the current [SingleUseCase].
     * With provided Schedulers
     */
    private fun buildUseCaseSingleWithSchedulers(params: Params?): Single<Results> {
        return buildUseCaseSingle(params)
                .subscribeOn(threadExecutorScheduler)
                .observeOn(postExecutionThreadScheduler)
    }
}
