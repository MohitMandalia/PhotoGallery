package com.mohitmandalia.photogallery

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 *   Created by Mohit Mandalia
 */

@HiltAndroidApp
class PhotoGalleryApp: Application() {

    override fun onCreate() {
        super.onCreate()

        if(BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            Timber.d("Timber setup complete")
        }
    }

}