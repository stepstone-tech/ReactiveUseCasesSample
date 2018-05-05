package com.stepstone.reactiveusecasessample.domain.interactor.base

import com.stepstone.reactiveusecasessample.domain.executor.PostExecutionThread
import com.stepstone.reactiveusecasessample.domain.executor.ThreadExecutor
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

abstract class BaseReactiveUseCase(
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) {

    protected val threadExecutorScheduler: Scheduler = Schedulers.from(threadExecutor)

    protected val postExecutionThreadScheduler: Scheduler = postExecutionThread.scheduler

    private val disposables = CompositeDisposable()

    open fun dispose() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }

    protected fun addDisposable(disposable: Disposable) {
        disposables.add(checkNotNull(disposable, { "disposable cannot be null!" }))
    }
}
