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

package com.stepstone.reactiveusecasessample.presentation.completable.view

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import butterknife.BindView
import com.stepstone.reactiveusecasessample.internal.activity.BaseActivity
import com.stepstone.reactiveusecasessample.presentation.completable.CompletableUseCaseSampleContract
import com.stepstone.reactiveusecasessample.R
import javax.inject.Inject

class CompletableUseCaseSampleActivity : BaseActivity(), CompletableUseCaseSampleContract.View {

    @Inject
    internal lateinit var presenter: CompletableUseCaseSampleContract.Presenter

    @BindView(R.id.successMessage)
    internal lateinit var successMessage: TextView

    @BindView(R.id.progressBar)
    internal lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_completable_use_case_sample)
        presenter.apply {
            attachView(this@CompletableUseCaseSampleActivity)
            uploadData()
        }
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

    override fun showError() {
    }

    override fun showSuccess() {
        successMessage.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
        successMessage.visibility = View.GONE
    }
}
