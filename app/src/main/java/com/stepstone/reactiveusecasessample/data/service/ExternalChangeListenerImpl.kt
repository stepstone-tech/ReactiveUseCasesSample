/*
 * Copyright (C) 2018 StepStone Services Sp. z o.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

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
