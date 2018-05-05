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
