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

package com.stepstone.reactiveusecasessample.presentation.synchronous.view

import android.os.Bundle
import android.support.v7.widget.SwitchCompat
import butterknife.BindView
import butterknife.OnCheckedChanged
import com.stepstone.reactiveusecasessample.R
import com.stepstone.reactiveusecasessample.internal.activity.BaseActivity
import com.stepstone.reactiveusecasessample.presentation.synchronous.SynchronousUseCaseSampleContract
import javax.inject.Inject

class SynchronousUseCaseSampleActivity : BaseActivity(), SynchronousUseCaseSampleContract.View {

    @Inject
    internal lateinit var presenter: SynchronousUseCaseSampleContract.Presenter

    @BindView(R.id.toggle)
    internal lateinit var toggle: SwitchCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_synchronous_use_case_sample)
        presenter.apply {
            attachView(this@SynchronousUseCaseSampleActivity)
        }
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

    override fun setToggleStatus(enabled: Boolean) {
        toggle.isChecked = enabled
    }

    @OnCheckedChanged(R.id.toggle)
    fun onToggleCheckedChanged(checked: Boolean) {
        presenter.toggleSampleFeature(checked)
    }
}
