package com.mohitmandalia.photogallery.core.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import dagger.hilt.android.qualifiers.ApplicationContext
import timber.log.Timber

/**
 *   Created by Mohit Mandalia
 */

class NetworkConnection(
    @ApplicationContext
    private val context: Context
) {

    private val connectivityService = Context.CONNECTIVITY_SERVICE
    private val connectivityManager = context.getSystemService(connectivityService) as ConnectivityManager

    companion object {
        private var isConnected: Boolean = false

        fun isConnected(): Boolean {
            return isConnected
        }
    }

    private val callback = object: ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            super.onAvailable(network)
            isConnected = true
            Timber.d("Internet is Available")
        }

        override fun onLosing(network: Network, maxMsToLive: Int) {
            super.onLosing(network, maxMsToLive)
            isConnected = false
            Timber.d("Internet is Losing")
        }

        override fun onLost(network: Network) {
            super.onLost(network)
            isConnected = false
            Timber.d("Internet is Lost")
        }

        override fun onUnavailable() {
            super.onUnavailable()
            isConnected = false
            Timber.d("Internet is Unavailable")
        }
    }

     fun registerConnection() {
        connectivityManager.registerDefaultNetworkCallback(callback)
    }

    fun unregisterConnection() {
        connectivityManager.unregisterNetworkCallback(callback)
    }
}