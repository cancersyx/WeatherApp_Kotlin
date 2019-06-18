package com.zsf.bambooweatherk.extensions

import android.content.Context
import android.support.v4.content.ContextCompat

/**
 * @author EWorld  e-mail:852333743@qq.com
 * 2019/6/18
 * @version
 *
 */
fun Context.color(res: Int): Int = ContextCompat.getColor(this, res)