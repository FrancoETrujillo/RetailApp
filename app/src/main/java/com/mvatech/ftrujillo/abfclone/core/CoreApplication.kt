package com.mvatech.ftrujillo.abfclone.core

import android.app.Application
import com.mvatech.ftrujillo.abfclone.BuildConfig
import timber.log.Timber

class CoreApplication: Application(){
    override fun onCreate() {
        super.onCreate()

        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}