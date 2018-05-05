/*
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * Copied from https://github.com/android10/Android-CleanArchitecture and converted to Kotlin.
 * Some stuff were extracted to BaseReactiveUseCase as well.
 */

package com.stepstone.reactiveusecasessample.domain.interactor.base

import com.stepstone.reactiveusecasessample.internal.rx.EmptyObserver
import com.stepstone.reactiveusecasessample.domain.executor.PostExecutionThread
import com.stepstone.reactiveusecasessample.domain.executor.ThreadExecutor
import io.reactivex.Observable
import io.reactivex.observers.DisposableObserver

/**
 * Abstract class for a Use Case (Interactor in terms of Clean Architecture).
 * This interface represents a execution unit for different use cases (this means any use case
 * in the application should implement this contract).
 *
 * By convention each UseCase implementation will return the result using a [DisposableObserver]
 * that will execute its job in a background thread and will post the result in the UI thread.
 *
 * This use case is to be used when we expect multiple values to be emitted via an [Observable].
 *
 *
 */
abstract class ObservableUseCase<Results, in Params>(
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : BaseReactiveUseCase(threadExecutor, postExecutionThread) {

    /**
     * Builds an [Observable] which will be used when executing the current [ObservableUseCase].
     */
    abstract fun buildUseCaseObservable(params: Params? = null): Observable<Results>

    /**
     * Executes the current use case.
     *
     * @param observer [DisposableObserver] which will be listening to the observer build
     * by [buildUseCaseObservable] method.
     * @param params Parameters (Optional) used to build/execute this use case.
     */
    fun execute(observer: DisposableObserver<Results> = EmptyObserver(), params: Params? = null) {
        val observable = buildUseCaseObservableWithSchedulers(params)
        addDisposable(observable.subscribeWith(observer))
    }

    /**
     * Builds an [Observable] which will be used when executing the current [ObservableUseCase].
     * With provided Schedulers
     */
    private fun buildUseCaseObservableWithSchedulers(params: Params?): Observable<Results> {
        return buildUseCaseObservable(params)
                .subscribeOn(threadExecutorScheduler)
                .observeOn(postExecutionThreadScheduler)
    }
}
