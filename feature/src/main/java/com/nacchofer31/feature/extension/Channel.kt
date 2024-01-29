package com.nacchofer31.feature.extension

import kotlinx.coroutines.channels.SendChannel

interface Routes {}

/**
 * Tries to send an element to a Channel and ignores the exception.
 */
suspend fun <E> SendChannel<E>.tryOffer(element: E): Boolean = try {
    send(element)
    true
} catch (t: Throwable) {
    false // Ignore
}