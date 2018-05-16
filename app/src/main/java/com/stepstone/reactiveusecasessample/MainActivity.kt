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

package com.stepstone.reactiveusecasessample

import android.content.Intent
import android.os.Bundle
import butterknife.OnClick
import com.stepstone.reactiveusecasessample.internal.activity.BaseActivity
import com.stepstone.reactiveusecasessample.presentation.completable.view.CompletableUseCaseSampleActivity
import com.stepstone.reactiveusecasessample.presentation.observable.view.ObservableUseCaseSampleActivity
import com.stepstone.reactiveusecasessample.presentation.single.view.SingleUseCaseSampleActivity
import com.stepstone.reactiveusecasessample.presentation.synchronous.view.SynchronousUseCaseSampleActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @OnClick(R.id.singleUseCase)
    fun onSingleUseCase() {
        startActivity(Intent(this, SingleUseCaseSampleActivity::class.java))
    }

    @OnClick(R.id.observableUseCase)
    fun onObservableUseCase() {
        startActivity(Intent(this, ObservableUseCaseSampleActivity::class.java))
    }

    @OnClick(R.id.completableUseCase)
    fun onCompletableUseCase() {
        startActivity(Intent(this, CompletableUseCaseSampleActivity::class.java))
    }

    @OnClick(R.id.synchronousUseCase)
    fun onSynchronousUseCase() {
        startActivity(Intent(this, SynchronousUseCaseSampleActivity::class.java))
    }
}
