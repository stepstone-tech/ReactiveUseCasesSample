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
