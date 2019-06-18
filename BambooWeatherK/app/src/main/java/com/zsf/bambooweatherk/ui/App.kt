package com.zsf.bambooweatherk.ui

import android.app.Application
import com.zsf.bambooweatherk.ui.utils.DelegatesExt

/**
 *
 * Created by EWorld
 * 2019/5/23 0023
 *
 */
class App : Application() {
    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}