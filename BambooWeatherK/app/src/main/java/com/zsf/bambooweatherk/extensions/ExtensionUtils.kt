package com.zsf.bambooweatherk.extensions

import java.text.DateFormat
import java.util.*

/**
 * @author EWorld  e-mail:852333743@qq.com
 * 2019/6/18
 * @version
 *
 */
fun Long.toDateString(dateFormat: Int = DateFormat.MEDIUM): String {
    val df = DateFormat.getDateInstance(dateFormat, Locale.getDefault())
    return df.format(this)
}