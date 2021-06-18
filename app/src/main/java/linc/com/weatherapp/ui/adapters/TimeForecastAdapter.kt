package linc.com.weatherapp.ui.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import linc.com.weatherapp.R
import java.util.*

class TimeForecastAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val forecasts = mutableListOf<Object>()

    fun setForecasts(forecasts: MutableList<Object>) {
        this.forecasts.clear()
        this.forecasts.addAll(forecasts)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ForecastViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.item_forecast_for_time,
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ForecastViewHolder).bind(position)
    }

    override fun getItemCount() = forecasts.size

    inner class ForecastViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(pos: Int) {
            if(pos == 2) {
                itemView.isSelected = true
                itemView.findViewById<TextView>(R.id.time).setTextColor(Color.WHITE)
                itemView.findViewById<TextView>(R.id.temperature).setTextColor(Color.WHITE)

                itemView.findViewById<ImageView>(R.id.forecastIcon).setColorFilter(
                    ContextCompat.getColor(itemView.context, android.R.color.white),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )
            } else {
                itemView.findViewById<TextView>(R.id.time).setTextColor(Color.BLACK)
                itemView.findViewById<TextView>(R.id.temperature).setTextColor(Color.BLACK)

                itemView.findViewById<ImageView>(R.id.forecastIcon).setColorFilter(
                    ContextCompat.getColor(itemView.context, android.R.color.black),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )
            }
        }

    }
}