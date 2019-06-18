package com.zsf.bambooweatherk.domain.commands

import com.zsf.bambooweatherk.data.server.ForecastByZipCodeRequest
import com.zsf.bambooweatherk.data.server.ServerDataMapper
import com.zsf.bambooweatherk.domain.datasource.ForecastProvider
import com.zsf.bambooweatherk.domain.model.ForecastList

/**
 *
 * Created by EWorld
 * 2019/5/20 0020
 *
 */
class RequestForecastCommand(
        private val zipCode:Long,
        private val forecastProvider:ForecastProvider = ForecastProvider()):Command<ForecastList> {

    companion object{
        const val DAYS = 7
    }

    override fun execute() = forecastProvider.requestByZipCode(zipCode, DAYS)
}