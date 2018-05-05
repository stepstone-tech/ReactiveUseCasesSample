package com.stepstone.reactiveusecasessample.internal.di.module

import android.app.Application
import com.stepstone.reactiveusecasessample.data.executor.JobExecutor
import com.stepstone.reactiveusecasessample.domain.executor.PostExecutionThread
import com.stepstone.reactiveusecasessample.domain.executor.ThreadExecutor
import com.stepstone.reactiveusecasessample.presentation.AndroidApplication
import com.stepstone.reactiveusecasessample.presentation.UIThread
import dagger.Binds
import dagger.Module

@Module
abstract class ApplicationModule {

    @Binds
    abstract fun bindThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor

    @Binds
    abstract fun bindPostExecutionThread(uiThread: UIThread): PostExecutionThread

    @Binds
    abstract fun bindApplication(app: AndroidApplication): Application
}
