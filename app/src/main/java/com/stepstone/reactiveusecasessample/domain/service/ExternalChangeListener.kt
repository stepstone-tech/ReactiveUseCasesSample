package com.stepstone.reactiveusecasessample.domain.service

import io.reactivex.Observable

interface ExternalChangeListener {

    /**
     * Emits events when make some external changes
     */
    fun onFavouriteChangeEvent(): Observable<Change>

    /**
     * Clears the listener.
     */
    fun dispose()

    class Change(val name: String)
}
