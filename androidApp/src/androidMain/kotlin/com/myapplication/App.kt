package com.myapplication

import android.app.Application
import initKoin
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()

    }
}