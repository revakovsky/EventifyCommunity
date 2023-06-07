package com.revakovskyi.eventifycommunity

import android.app.Application
import android.content.Context
import com.revakovskyi.eventifycommunity.di.AppComponent
import com.revakovskyi.eventifycommunity.di.DaggerAppComponent

class App : Application() {

    private var _appComponent: AppComponent? = null
    val appComponent: AppComponent
        get() = checkNotNull(_appComponent)

    override fun onCreate() {
        super.onCreate()

        _appComponent = DaggerAppComponent
            .builder()
            .application(this)
            .create()
    }

}

val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> (applicationContext as App).appComponent
    }