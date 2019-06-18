package com.zsf.bambooweatherk.data.server

import com.zsf.bambooweatherk.domain.model.ForecastList
import java.util.*
import java.util.concurrent.TimeUnit
import com.zsf.bambooweatherk.domain.model.Forecast as ModelForecast

/**
 *
 * Created by EWorld
 * 2019/5/20 0020
 *
 */
class ServerDataMapper {

    fun convertToDomain(zipCode:Long,forecast:ForecastResult) = with(forecast){
        ForecastList(zipCode,city.name,city.country,convertForecastListToDomain(list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.mapIndexed { i, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
            convertForecastItemToDomain(forecast.copy(dt = dt))
        }
    }

//    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
//        return ModelForecast(convertDate(forecast.dt),
//                forecast.weather[0].description,
//                forecast.temp.max.toInt(),
//                forecast.temp.min.toInt(),
//                generateIconUrl(forecast.weather[0].icon))
//    }

    private fun convertForecastItemToDomain(forecast: Forecast) = with(forecast) {
        ModelForecast(-1,dt, weather[0].description, temp.max.toInt(), temp.min.toInt(),
                generateIconUrl(weather[0].icon))
    }

    private fun generateIconUrl(iconCode: String): String = "http://openweathermap.org/img/w/$iconCode.png"

//    private fun convertDate(date: Long): String {
//        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
//        return df.format(date)
//    }

}