package com.example.nigeriatelemedicineapp

import android.app.Application
import com.crashlytics.android.Crashlytics
import com.example.nigeriatelemedicineapp.BuildConfig.DEBUG
import io.fabric.sdk.android.Fabric
import timber.log.Timber

class TelemedicineApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Fabric.with(this, Crashlytics())
        if(DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        else{
            //custom logger to be planted if required for release
        }

    }
}