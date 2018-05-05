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
