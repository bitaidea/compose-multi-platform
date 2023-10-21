package com.myapplication

import DriverFactory
import android.app.Application
import initKoin
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin(DriverFactory(this).createDriver())
    }
}