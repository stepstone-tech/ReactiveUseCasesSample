package com.stepstone.reactiveusecasessample.presentation.observable.di

import com.stepstone.reactiveusecasessample.data.service.ExternalChangeListenerImpl
import com.stepstone.reactiveusecasessample.domain.service.ExternalChangeListener
import com.stepstone.reactiveusecasessample.presentation.observable.ObservableUseCaseSampleContract
import com.stepstone.reactiveusecasessample.presentation.observable.presenter.ObservableUseCaseSamplePresenter
import dagger.Binds
import dagger.Module

@Module
abstract class ObservableUseCaseSampleActivityModule {

    @Binds
    abstract fun bindPresenter(presenter: ObservableUseCaseSamplePresenter): ObservableUseCaseSampleContract.Presenter

    @Binds
    abstract fun bindExternalChangeListener(repositoryImpl: ExternalChangeListenerImpl): ExternalChangeListener
}
