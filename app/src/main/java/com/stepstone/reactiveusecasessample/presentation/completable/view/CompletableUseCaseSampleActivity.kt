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
