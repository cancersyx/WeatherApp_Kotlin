package com.zsf.bambooweatherk.extensions

import android.content.Context
import android.view.View
import android.widget.TextView

/**
 *
 * Created by EWorld
 * 2019/6/15 0015
 *
 */
val View.ctx: Context
    get() = context

var TextView.textColor: Int
    get() = currentTextColor
    set(v) = setTextColor(v)