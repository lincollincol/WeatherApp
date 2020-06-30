package linc.com.weatherapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckedTextView
import androidx.recyclerview.widget.RecyclerView
import linc.com.weatherapp.R
import linc.com.weatherapp.domain.entities.CityEntity

class CitiesAdapter : RecyclerView.Adapter<CitiesAdapter.CityViewHolder>() {

    private val cities = mutableListOf<CityEntity>()

    fun updateTimeWeathers(cities: List<CityEntity>) {
        this.cities.clear()
        this.cities.addAll(cities)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CityViewHolder (
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_city, parent, false)
    )
    override fun getItemCount() = cities.count()

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(cities[position])
    }

    inner class CityViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        fun bind(cityEntity: CityEntity) {
            (itemView as CheckedTextView).text = cityEntity.cityTitle
            itemView.isChecked = cityEntity.selected
        }
    }

}