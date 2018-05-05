package com.stepstone.reactiveusecasessample.presentation.completable.di

import com.stepstone.reactiveusecasessample.data.repository.ContentRepositoryImpl
import com.stepstone.reactiveusecasessample.domain.repository.ContentRepository
import com.stepstone.reactiveusecasessample.presentation.completable.CompletableUseCaseSampleContract
import com.stepstone.reactiveusecasessample.presentation.completable.presenter.CompletableUseCaseSamplePresenter
import dagger.Binds
import dagger.Module

@Module
abstract class CompletableUseCaseSampleActivityModule {

    @Binds
    abstract fun bindPresenter(presenter: CompletableUseCaseSamplePresenter): CompletableUseCaseSampleContract.Presenter

    @Binds
    abstract fun bindContentRepository(repositoryImpl: ContentRepositoryImpl): ContentRepository
}
