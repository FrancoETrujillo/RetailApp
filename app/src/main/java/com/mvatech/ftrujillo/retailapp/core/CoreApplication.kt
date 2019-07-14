package com.mvatech.ftrujillo.retailapp.core

import android.app.Application
import com.mvatech.ftrujillo.retailapp.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class CoreApplication: Application(){
    override fun onCreate() {
        super.onCreate()

        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }

        startKoin{
            androidLogger()
            androidContext(this@CoreApplication)
            modules(appModule)
        }
    }
}