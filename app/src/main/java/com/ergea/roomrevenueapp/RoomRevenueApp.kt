package com.ergea.roomrevenueapp

import android.app.Application
import com.ergea.roomrevenueapp.di.AppModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext


class RoomRevenueApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        GlobalContext.startKoin {
            androidLogger()
            androidContext(this@RoomRevenueApp)
            modules(AppModules.modules)
        }
    }
}