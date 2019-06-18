package com.zsf.bambooweatherk.data.db

import com.zsf.bambooweatherk.domain.model.Forecast
import com.zsf.bambooweatherk.domain.model.ForecastList

/**
 *
 * Created by EWorld
 * 2019/6/14 0014
 *
 */
class DbDataMapper {
    fun convertFromDomain(forecast:ForecastList) = with(forecast){
        val daily = dailyForecast.map { convertFromDomain(id,it) }
        CityForecast(id,city,country,daily)
    }

    private fun convertFromDomain(cityId:Long,forecast: Forecast) = with(forecast){
        DayForecast(date,description,high,low,iconUrl,cityId)
    }

    fun convertToDomain(forecast: CityForecast) = with(forecast){
        val daily = dailyForecast.map { convertDayToDomain(it) }
        ForecastList(_id,city,country,daily)
    }

    fun convertDayToDomain(dayForecast :DayForecast)= with(dayForecast){
        Forecast(_id,date,description,high,low,iconUrl)
    }
}