package com.stepstone.reactiveusecasessample.data.service

import android.app.Application
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v4.content.LocalBroadcastManager
import com.stepstone.reactiveusecasessample.domain.service.ExternalChangeListener
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class ExternalChangeListenerImpl
@Inject
constructor(application: Application) : ExternalChangeListener {

    private val localBroadcastManager by lazy { LocalBroadcastManager.getInstance(application) }

    private val externalChangeSubject = PublishSubject.create<ExternalChangeListener.Change>()

    private var externalChangeBroadcastReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val listingIdToUpdate = intent.extras?.getString("name")
            externalChangeSubject.onNext(ExternalChangeListener.Change(
                    name = listingIdToUpdate ?: "unknown"))
        }
    }

    override fun onFavouriteChangeEvent(): Observable<ExternalChangeListener.Change> {
        val intentFilter = IntentFilter().apply {
            addAction("user_action")
        }
        localBroadcastManager.registerReceiver(externalChangeBroadcastReceiver, intentFilter)
        return externalChangeSubject
    }

    override fun dispose() {
        localBroadcastManager.unregisterReceiver(externalChangeBroadcastReceiver)
    }
}
