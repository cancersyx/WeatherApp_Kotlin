package com.zsf.bambooweatherk.data.server

import com.zsf.bambooweatherk.data.db.ForecastDb
import com.zsf.bambooweatherk.domain.datasource.ForecastDataSource
import com.zsf.bambooweatherk.domain.model.ForecastList

/**
 * @author EWorld  e-mail:852333743@qq.com
 * 2019/6/16
 * @version
 *
 */
class ForecastServer(private val dataMapper: ServerDataMapper = ServerDataMapper(),
                     private val forecastDb: ForecastDb = ForecastDb()) : ForecastDataSource {

    override fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList? {
        val result = ForecastByZipCodeRequest(zipCode).execute()
        val converted = dataMapper.convertToDomain(zipCode, result)
        forecastDb.saveForecast(converted)
        return forecastDb.requestForecastByZipCode(zipCode, date)
    }

    override fun requestDayForecast(id:Long) = throw UnsupportedOperationException()
}