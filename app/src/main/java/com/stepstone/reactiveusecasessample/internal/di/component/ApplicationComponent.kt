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

package com.stepstone.reactiveusecasessample.internal.di.component

import com.stepstone.reactiveusecasessample.domain.executor.PostExecutionThread
import com.stepstone.reactiveusecasessample.domain.executor.ThreadExecutor
import com.stepstone.reactiveusecasessample.internal.di.module.ActivityContributorModule
import com.stepstone.reactiveusecasessample.internal.di.module.ApplicationModule
import com.stepstone.reactiveusecasessample.presentation.AndroidApplication
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ActivityContributorModule::class, ApplicationModule::class])
interface ApplicationComponent : AndroidInjector<AndroidApplication> {

    fun threadExecutor(): ThreadExecutor

    fun postExecutionThread(): PostExecutionThread

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<AndroidApplication>() {

        abstract override fun build(): ApplicationComponent
    }
}
