package com.zsf.bambooweatherk.domain.commands

/**
 *
 * Created by EWorld
 * 2019/5/20 0020
 *
 */
interface Command<out T> {
    fun execute(): T
}