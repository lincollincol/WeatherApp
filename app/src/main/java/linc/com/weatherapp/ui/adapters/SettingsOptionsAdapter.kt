package linc.com.weatherapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.RecyclerView
import linc.com.weatherapp.R
import linc.com.weatherapp.domain.entities.SettingsOptionEntity

class SettingsOptionsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val settingsOptions = mutableListOf<SettingsOptionEntity>()

    fun updateTimeWeathers(settingsOptions: List<SettingsOptionEntity>) {
        this.settingsOptions.clear()
        this.settingsOptions.addAll(settingsOptions)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return settingsOptions[position].settingsType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when(viewType) {
            SettingsOptionEntity.TEXT -> SettingsTextOptionViewHolder(inflater.inflate(R.layout.item_settings_text, parent, false))
            else -> SettingsToggleOptionViewHolder(inflater.inflate(R.layout.item_settings_toggle, parent, false))
        }
    }

    override fun getItemCount() = settingsOptions.count()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(settingsOptions[position].settingsType) {
            SettingsOptionEntity.TEXT -> (holder as SettingsTextOptionViewHolder).bind(settingsOptions[position])
            SettingsOptionEntity.TOGGLE -> (holder as SettingsToggleOptionViewHolder).bind(settingsOptions[position])
        }
    }

    inner class SettingsToggleOptionViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        fun bind(settingsOption: SettingsOptionEntity) {
            itemView.findViewById<TextView>(R.id.settingsOptionTitle).text = settingsOption.optionTitle
            itemView.findViewById<SwitchCompat>(R.id.settingsOptionToggle).isChecked = settingsOption.checked
        }
    }

    inner class SettingsTextOptionViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        fun bind(settingsOption: SettingsOptionEntity) {
            itemView.findViewById<TextView>(R.id.settingsOptionTitle).text = settingsOption.optionTitle
            itemView.findViewById<TextView>(R.id.settingsOptionValue).text = settingsOption.value
        }
    }

}