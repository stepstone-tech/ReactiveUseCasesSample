package com.stepstone.reactiveusecasessample.presentation.observable.view

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import android.widget.TextView
import butterknife.BindView
import butterknife.OnClick
import com.stepstone.reactiveusecasessample.R
import com.stepstone.reactiveusecasessample.internal.activity.BaseActivity
import com.stepstone.reactiveusecasessample.presentation.observable.ObservableUseCaseSampleContract
import javax.inject.Inject

class ObservableUseCaseSampleActivity : BaseActivity(), ObservableUseCaseSampleContract.View {

    @Inject
    internal lateinit var presenter: ObservableUseCaseSampleContract.Presenter

    @BindView(R.id.title)
    internal lateinit var title: TextView

    @Inject
    internal lateinit var application: Application

    private var clickCount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_observable_use_case_sample)
        presenter.apply {
            attachView(this@ObservableUseCaseSampleActivity)
            loadExternalEvents()
        }
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

    override fun showExternalEvent(eventName: String) {
        title.text = eventName
    }

    @OnClick(R.id.externalEventButton)
    fun onExternalEventButtonClicked() {
        /* The code below does not comply with Clean Architecture.
         * This event would normally get triggered somewhere else,
         * but for simplicity and demo purposes we use it here.
         */
        clickCount++
        val intent = Intent().apply {
            action = "user_action"
            putExtra("name", "User clicked button $clickCount times.")
            `package` = packageName
        }
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
    }
}
