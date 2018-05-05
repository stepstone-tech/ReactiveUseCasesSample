package com.stepstone.reactiveusecasessample.internal.di.module

import com.stepstone.reactiveusecasessample.MainActivity
import com.stepstone.reactiveusecasessample.presentation.completable.di.CompletableUseCaseSampleActivityModule
import com.stepstone.reactiveusecasessample.presentation.completable.view.CompletableUseCaseSampleActivity
import com.stepstone.reactiveusecasessample.presentation.observable.di.ObservableUseCaseSampleActivityModule
import com.stepstone.reactiveusecasessample.presentation.observable.view.ObservableUseCaseSampleActivity
import com.stepstone.reactiveusecasessample.presentation.single.di.SingleUseCaseSampleActivityModule
import com.stepstone.reactiveusecasessample.presentation.single.view.SingleUseCaseSampleActivity
import com.stepstone.reactiveusecasessample.presentation.synchronous.di.SynchronousUseCaseSampleActivityModule
import com.stepstone.reactiveusecasessample.presentation.synchronous.view.SynchronousUseCaseSampleActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityContributorModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [SingleUseCaseSampleActivityModule::class])
    abstract fun contributeSingleUseCaseActivity(): SingleUseCaseSampleActivity

    @ContributesAndroidInjector(modules = [ObservableUseCaseSampleActivityModule::class])
    abstract fun contributeObservableUseCaseActivity(): ObservableUseCaseSampleActivity

    @ContributesAndroidInjector(modules = [CompletableUseCaseSampleActivityModule::class])
    abstract fun contributeCompletableUseCaseActivity(): CompletableUseCaseSampleActivity

    @ContributesAndroidInjector(modules = [SynchronousUseCaseSampleActivityModule::class])
    abstract fun contributeSynchronousUseCaseActivity(): SynchronousUseCaseSampleActivity
}
