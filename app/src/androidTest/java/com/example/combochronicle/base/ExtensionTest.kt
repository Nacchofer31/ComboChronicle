package com.example.combochronicle.base

import android.content.Context
import androidx.annotation.StringRes
import androidx.test.platform.app.InstrumentationRegistry

private val context: Context = InstrumentationRegistry.getInstrumentation().targetContext
fun strTag(@StringRes resource:Int): String = context.getString(resource)