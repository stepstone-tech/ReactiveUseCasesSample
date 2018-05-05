package com.stepstone.reactiveusecasessample.presentation.synchronous.di

import com.stepstone.reactiveusecasessample.data.repository.LocalPreferencesRepositoryImpl
import com.stepstone.reactiveusecasessample.data.repository.TrackingRepositoryImpl
import com.stepstone.reactiveusecasessample.domain.repository.LocalPreferencesRepository
import com.stepstone.reactiveusecasessample.domain.repository.TrackingRepository
import com.stepstone.reactiveusecasessample.presentation.synchronous.SynchronousUseCaseSampleContract
import com.stepstone.reactiveusecasessample.presentation.synchronous.presenter.SynchronousUseCaseSamplePresenter
import dagger.Binds
import dagger.Module

@Module
abstract class SynchronousUseCaseSampleActivityModule {

    @Binds
    abstract fun bindPresenter(presenter: SynchronousUseCaseSamplePresenter): SynchronousUseCaseSampleContract.Presenter

    @Binds
    abstract fun bindTrackingRepository(trackingRepositoryImpl: TrackingRepositoryImpl): TrackingRepository

    @Binds
    abstract fun bindLocalPreferencesRepository(localPreferencesRepositoryImpl: LocalPreferencesRepositoryImpl): LocalPreferencesRepository
}
