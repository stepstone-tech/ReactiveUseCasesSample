package com.stepstone.reactiveusecasessample.presentation

import com.stepstone.reactiveusecasessample.internal.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class AndroidApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out AndroidApplication> =
            DaggerApplicationComponent.builder().create(this)
}
