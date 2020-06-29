package linc.com.weatherapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.AutoTransition
import androidx.transition.TransitionManager
import linc.com.weatherapp.R
import linc.com.weatherapp.domain.entities.TimeWeatherEntity

class TimeWeatherAdapter : RecyclerView.Adapter<TimeWeatherAdapter.TimeWeatherViewHolder>() {

    private val timeWeathers = mutableListOf<TimeWeatherEntity>()

    fun updateTimeWeathers(timeWeathers: List<TimeWeatherEntity>) {
        this.timeWeathers.clear()
        this.timeWeathers.addAll(timeWeathers)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TimeWeatherViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_day_time_weather, parent, false)
    )

    override fun getItemCount() = timeWeathers.count()

    override fun onBindViewHolder(holder: TimeWeatherViewHolder, position: Int) {
        holder.bind(timeWeathers[position])
    }

    inner class TimeWeatherViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        private var expanded = false
        fun bind(timeWeather: TimeWeatherEntity) {
            itemView.findViewById<TextView>(R.id.time).text = timeWeather.time
            itemView.findViewById<TextView>(R.id.details).text = timeWeather.time

            itemView.setOnClickListener {
                expanded = !expanded
                TransitionManager.beginDelayedTransition(
                    itemView.findViewById(R.id.timeWeatherLayout),
                    AutoTransition().apply {
                        duration = 500
                    }
                )
                itemView.findViewById<TextView>(R.id.details).text = when(expanded) {
                    true -> "Max: ${timeWeather.maxTemperature}\nMin: ${timeWeather.minTemperature}\nWind: ${(timeWeather.minTemperature + timeWeather.maxTemperature)/2}ms"
                    else -> "Details"
                }
            }
        }
    }

}