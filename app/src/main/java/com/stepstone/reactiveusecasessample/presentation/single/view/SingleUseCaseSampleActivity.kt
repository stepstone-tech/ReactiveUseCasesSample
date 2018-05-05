package com.stepstone.reactiveusecasessample.presentation.single.view

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ProgressBar
import android.widget.TextView
import butterknife.BindView
import com.stepstone.reactiveusecasessample.R
import com.stepstone.reactiveusecasessample.domain.model.Content
import com.stepstone.reactiveusecasessample.internal.activity.BaseActivity
import com.stepstone.reactiveusecasessample.presentation.single.SingleUseCaseSampleContract
import javax.inject.Inject

class SingleUseCaseSampleActivity : BaseActivity(), SingleUseCaseSampleContract.View {

    @Inject
    internal lateinit var presenter: SingleUseCaseSampleContract.Presenter

    @BindView(R.id.title)
    internal lateinit var title: TextView

    @BindView(R.id.description)
    internal lateinit var description: TextView

    @BindView(R.id.progressBar)
    internal lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_use_case_sample)
        presenter.apply {
            attachView(this@SingleUseCaseSampleActivity)
            loadContent()
        }
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

    override fun showContent(content: Content) {
        progressBar.visibility = GONE
        title.apply {
            visibility = VISIBLE
            text = content.title
        }
        description.apply {
            visibility = VISIBLE
            text = content.description
        }
    }

    override fun showProgress() {
        progressBar.visibility = VISIBLE
        title.visibility = GONE
        description.visibility = GONE
    }

    override fun showError() {
    }
}
