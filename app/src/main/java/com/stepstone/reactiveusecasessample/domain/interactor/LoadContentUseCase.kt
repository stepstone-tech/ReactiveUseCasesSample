package com.stepstone.reactiveusecasessample.domain.interactor

import com.stepstone.reactiveusecasessample.domain.executor.PostExecutionThread
import com.stepstone.reactiveusecasessample.domain.executor.ThreadExecutor
import com.stepstone.reactiveusecasessample.domain.interactor.base.SingleUseCase
import com.stepstone.reactiveusecasessample.domain.model.Content
import com.stepstone.reactiveusecasessample.domain.repository.ContentRepository
import io.reactivex.Single
import javax.inject.Inject

class LoadContentUseCase
@Inject
constructor(
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
    private val contentRepository: ContentRepository
) : SingleUseCase<Content, Unit>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseSingle(params: Unit?): Single<Content> {
        return contentRepository.loadContent()
    }
}
