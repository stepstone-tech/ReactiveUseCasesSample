package com.stepstone.reactiveusecasessample.domain.interactor

import com.stepstone.reactiveusecasessample.domain.executor.PostExecutionThread
import com.stepstone.reactiveusecasessample.domain.executor.ThreadExecutor
import com.stepstone.reactiveusecasessample.domain.interactor.base.CompletableUseCase
import com.stepstone.reactiveusecasessample.domain.repository.ContentRepository
import io.reactivex.Completable
import javax.inject.Inject

class UploadContentUseCase
@Inject
constructor(
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
    private val contentRepository: ContentRepository
) : CompletableUseCase<Unit>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseCompletable(params: Unit?): Completable {
        return contentRepository.uploadContent()
    }
}
