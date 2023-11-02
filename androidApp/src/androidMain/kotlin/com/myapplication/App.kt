package com.myapplication

import DriverFactory
import Strings
import android.app.Application
import initKoin
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin(DriverFactory(this).createDriver())
        Strings.context = this
    }
}