package com.zsf.bambooweatherk.domain.datasource

import com.zsf.bambooweatherk.data.db.ForecastDb
import com.zsf.bambooweatherk.data.server.ForecastServer
import com.zsf.bambooweatherk.domain.model.Forecast
import com.zsf.bambooweatherk.domain.model.ForecastList
import com.zsf.bambooweatherk.extensions.firstResult

/**
 * @author EWorld  e-mail:852333743@qq.com
 * 2019/6/16
 * @version
 *
 */
class ForecastProvider(private val sources: List<ForecastDataSource> = ForecastProvider.SOURCE) {

    companion object {
        const val DAY_IN_MILLIS = 1000 * 60 * 60 * 24
        val SOURCE = listOf(ForecastDb(), ForecastServer())
    }

    fun requestByZipCode(zipCode: Long, days: Int): ForecastList = requestToSources {
        val res = it.requestForecastByZipCode(zipCode, todayTimeSpan())
        if (res != null && res.size() >= days) res else null
    }

    fun requestForecast(id: Long): Forecast = requestToSources { it.requestDayForecast(id) }


    private fun todayTimeSpan() = System.currentTimeMillis() / DAY_IN_MILLIS * DAY_IN_MILLIS

    private fun <T : Any> requestToSources(f: (ForecastDataSource) -> T?): T = sources.firstResult { f(it) }
}