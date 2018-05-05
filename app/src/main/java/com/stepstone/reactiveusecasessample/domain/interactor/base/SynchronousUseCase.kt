package com.stepstone.reactiveusecasessample.domain.interactor.base

/**
 * Interface for a Use Case (Interactor in terms of Clean Architecture).
 * This interface represents a execution unit for different use cases (this means any use case
 * in the application should implement this contract).
 *
 * This use case is to be used for quick synchronous operations that do not require RxJava/threading.
 * They don't also need to be disposed.
 */
interface SynchronousUseCase<out Results, in Params> {

    /**
     * Executes the current use case and returns the result immediately.
     * If this should not return anything then use [Unit] as [Results].
     */
    fun execute(params: Params? = null): Results
}
