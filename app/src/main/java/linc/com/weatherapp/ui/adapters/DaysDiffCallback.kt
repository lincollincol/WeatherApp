package linc.com.weatherapp.ui.adapters

import androidx.recyclerview.widget.DiffUtil
import linc.com.weatherapp.domain.entities.WeekDayEntity

class DaysDiffCallback(
    private val oldDays: List<WeekDayEntity>,
    private val newDays: List<WeekDayEntity>
) : DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldDays[oldItemPosition] == newDays[newItemPosition]
    }

    override fun getOldListSize() = oldDays.count()

    override fun getNewListSize() = newDays.count()

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldDays[oldItemPosition].dayOfWeek == newDays[newItemPosition].dayOfWeek
    }
}