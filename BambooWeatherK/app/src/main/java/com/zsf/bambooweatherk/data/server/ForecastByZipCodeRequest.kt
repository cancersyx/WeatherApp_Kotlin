package com.zsf.bambooweatherk.data.server

import android.util.Log
import com.google.gson.Gson
import java.net.URL

/**
 *
 * Created by EWorld
 * 2019/5/20 0020
 *
 */
class ForecastByZipCodeRequest(private val zipCode: Long,val gson: Gson = Gson()) {
    companion object {
        private const val APP_ID = "d1f8f59c26d34eca78cf9adc0cde36d2"
        //private const val URL = "http://api.openweathermap.org/data/2.5/weather?q=suzhou"
        private const val URL = "http://api.openweathermap.org/data/2.5/forecast/daily?mode=json&units=metric&cnt=7"
        //private const val COMPLETE_URL = "$URL&appid=$APP_ID&zip="
        private const val COMPLETE_URL = "$URL&APPID=$APP_ID&q="
    }

    fun execute(): ForecastResult {
        Log.d(javaClass.simpleName,"complete url is " + COMPLETE_URL)
        val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()
        return gson.fromJson(forecastJsonStr, ForecastResult::class.java)
    }

}