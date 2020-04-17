package com.catfacts

import android.app.Application
import com.catfacts.di.AppComponent
import com.catfacts.di.AppModule
import com.catfacts.di.DaggerAppComponent

class App : Application() {

    private var component: AppComponent? = null

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }

    fun getComponent(): AppComponent? {
        return component
    }

}
