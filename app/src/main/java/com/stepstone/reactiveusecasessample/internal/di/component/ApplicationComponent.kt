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
