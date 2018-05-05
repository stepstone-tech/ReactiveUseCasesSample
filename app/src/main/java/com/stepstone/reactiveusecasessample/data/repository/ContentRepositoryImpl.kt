package com.stepstone.reactiveusecasessample.data.repository

import com.stepstone.reactiveusecasessample.domain.model.Content
import com.stepstone.reactiveusecasessample.domain.repository.ContentRepository
import io.reactivex.Completable
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ContentRepositoryImpl
@Inject
constructor() : ContentRepository {

    override fun loadContent(): Single<Content> {
        // an actual API call would take place here e.g. using Retrofit + some mapping from data layer to domain layer
        return Single.fromCallable {
            Content(
                "some title",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
            )
        }.delay(1, TimeUnit.SECONDS)
    }

    override fun uploadContent(): Completable {
        // an actual API call would take place here e.g. using Retrofit
        return Completable.complete().delay(2L, TimeUnit.SECONDS)
    }
}
