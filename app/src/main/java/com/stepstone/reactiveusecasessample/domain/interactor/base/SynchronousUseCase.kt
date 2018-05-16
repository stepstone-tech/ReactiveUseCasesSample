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
