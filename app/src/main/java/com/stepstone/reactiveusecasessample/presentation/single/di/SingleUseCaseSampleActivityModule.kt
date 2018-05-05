package com.stepstone.reactiveusecasessample.presentation.single.di

import com.stepstone.reactiveusecasessample.data.repository.ContentRepositoryImpl
import com.stepstone.reactiveusecasessample.domain.repository.ContentRepository
import com.stepstone.reactiveusecasessample.presentation.single.SingleUseCaseSampleContract
import com.stepstone.reactiveusecasessample.presentation.single.presenter.SingleUseCaseSamplePresenter
import dagger.Binds
import dagger.Module

@Module
abstract class SingleUseCaseSampleActivityModule {

    @Binds
    abstract fun bindPresenter(presenter: SingleUseCaseSamplePresenter): SingleUseCaseSampleContract.Presenter

    @Binds
    abstract fun bindContentRepository(repositoryImpl: ContentRepositoryImpl): ContentRepository
}
