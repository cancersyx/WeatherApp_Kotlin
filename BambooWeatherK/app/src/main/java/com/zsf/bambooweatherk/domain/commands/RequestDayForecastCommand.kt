package com.zsf.bambooweatherk.domain.commands

import com.zsf.bambooweatherk.domain.datasource.ForecastProvider
import com.zsf.bambooweatherk.domain.model.Forecast

/**
 * @author EWorld  e-mail:852333743@qq.com
 * 2019/6/18
 * @version
 *
 */
class RequestDayForecastCommand (
    val id: Long,
            private val forecastProvider:ForecastProvider = ForecastProvider()):Command<Forecast>{
    override fun execute() = forecastProvider.requestForecast(id)

}