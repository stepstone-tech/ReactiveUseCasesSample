package com.stepstone.reactiveusecasessample.domain.repository

import com.stepstone.reactiveusecasessample.domain.model.Content
import io.reactivex.Completable
import io.reactivex.Single

interface ContentRepository {

    fun loadContent(): Single<Content>

    fun uploadContent(): Completable
}
