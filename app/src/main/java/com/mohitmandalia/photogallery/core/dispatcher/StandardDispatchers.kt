package com.mohitmandalia.photogallery.core.dispatcher

import kotlinx.coroutines.CoroutineDispatcher

/**
 *   Created by Mohit Mandalia
 */
interface StandardDispatchers {

    val default: CoroutineDispatcher

    val main: CoroutineDispatcher

    val io: CoroutineDispatcher

    val unconfined: CoroutineDispatcher
}