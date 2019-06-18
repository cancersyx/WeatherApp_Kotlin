package com.zsf.bambooweatherk.ui.adapters

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import com.zsf.bambooweatherk.R
import com.zsf.bambooweatherk.domain.model.Forecast
import com.zsf.bambooweatherk.domain.model.ForecastList
import com.zsf.bambooweatherk.extensions.toDateString
import com.zsf.bambooweatherk.ui.utils.ctx
import kotlinx.android.synthetic.main.item_forecast.view.*
import java.text.DateFormat
import java.util.*

/**
 *
 * Created by EWorld
 * 2019/5/16 0016
 *
 */
class ForecastListAdapter(private val weekForecast: ForecastList,
                          private val itemClick: (Forecast) -> Unit) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int = weekForecast.size()

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }


    class ViewHolder(view: View, private val itemClick: (Forecast) -> Unit) : RecyclerView.ViewHolder(view) {

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.get().load(iconUrl).into(itemView.icon)
                itemView.tv_date.text = date.toDateString()
                itemView.tv_description.text = description
                itemView.tv_max_temperature.text = "${high}°"
                itemView.tv_min_temperature.text = "${low}°"
                itemView.setOnClickListener {
                    itemClick(this)
                }
            }
        }
    }
}