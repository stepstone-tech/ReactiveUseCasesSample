package com.stepstone.reactiveusecasessample.internal.rx

import io.reactivex.observers.DisposableSingleObserver

open class EmptySingleObserver<T> : DisposableSingleObserver<T>() {

    override fun onSuccess(result: T) {}

    override fun onError(throwable: Throwable) {}
}
