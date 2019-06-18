package com.example.nigeriatelemedicineapp

import android.app.Application
import com.example.nigeriatelemedicineapp.BuildConfig.DEBUG
import timber.log.Timber

class TelemedicineApp : Application() {

    override fun onCreate() {
        super.onCreate()

        if(DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        else{
            //custom logger to be planted if required for release
        }

    }
}