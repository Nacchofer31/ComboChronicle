package com.nacchofer31.feature.routes

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavDirections

sealed class NavEvent {
    data class NavToDirectionId(@IdRes val idDirection: Int, val bundle: Bundle? = null) :
        NavEvent()

    data class NavToDirection(val direction: NavDirections, val bundle: Bundle? = null) : NavEvent()
    object NavigateHome : NavEvent()
    object Back : NavEvent()
}