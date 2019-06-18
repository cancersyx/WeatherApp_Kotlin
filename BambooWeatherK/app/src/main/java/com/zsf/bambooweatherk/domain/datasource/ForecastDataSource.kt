package com.zsf.bambooweatherk.domain.datasource

import com.zsf.bambooweatherk.domain.model.Forecast
import com.zsf.bambooweatherk.domain.model.ForecastList

/**
 * @author EWorld  e-mail:852333743@qq.com
 * 2019/6/16
 * @version
 *
 */
interface ForecastDataSource {
    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?

    fun requestDayForecast(id:Long):Forecast?
}