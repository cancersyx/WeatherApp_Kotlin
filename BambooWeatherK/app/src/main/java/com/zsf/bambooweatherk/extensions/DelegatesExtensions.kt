package com.zsf.bambooweatherk.extensions

import java.lang.IllegalStateException
import kotlin.reflect.KProperty

/**
 *
 * Created by EWorld
 * 2019/6/15 0015
 *
 */

object DelegateExt {
    fun <T> notNullSingleValue() = NotNullSingleValueVar<T>()


    class NotNullSingleValueVar<T> {
        private var value:T? = null

        operator fun getValue(thisRef:Any?,property:KProperty<*>):T=
                value ?: throw IllegalStateException("${property.name} not initialized")

        operator fun setValue(thisRef: Any?,property: KProperty<*>,value:T){
            this.value = if(this.value == null) value
            else throw IllegalStateException("${property.name} already initialized")
        }
    }
}