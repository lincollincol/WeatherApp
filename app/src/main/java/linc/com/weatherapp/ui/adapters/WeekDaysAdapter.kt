package linc.com.weatherapp.ui.adapters

import android.content.Context
import android.graphics.Point
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import android.view.WindowManager
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import linc.com.weatherapp.R
import linc.com.weatherapp.domain.entities.WeekDayEntity
import linc.com.weatherapp.utils.ScreenSizeUtil


class WeekDaysAdapter : RecyclerView.Adapter<WeekDaysAdapter.WeekDayViewHolder>() {

    private lateinit var weekDayClickListener: WeekDayClickListener
    private val days = mutableListOf<WeekDayEntity>()

    fun updateDays(days: List<WeekDayEntity>) {
//        val diffResult = DiffUtil.calculateDiff(DaysDiffCallback(this.days, days))
//        diffResult.dispatchUpdatesTo(this)
        this.days.clear()
        this.days.addAll(days)
        notifyDataSetChanged()
    }

    fun refresh() {
        notifyDataSetChanged()
    }

    fun setOnWeekDayClickListener(weekDayClickListener: WeekDayClickListener) {
        this.weekDayClickListener = weekDayClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = WeekDayViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_day_weather, parent, false)
    )

    override fun onBindViewHolder(holder: WeekDayViewHolder, position: Int) {
        holder.bind(
            days[position],
            position == 0,
            position == days.lastIndex
        )
    }

    override fun getItemCount() = days.count()

    inner class WeekDayViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private val dayOfWeek = itemView.findViewById<TextView>(R.id.dayOfWeek)
//        private val dayAndMonth = itemView.findViewById<TextView>(R.id.dayAndMonth)
//        private val city = itemView.findViewById<TextView>(R.id.city)
        private val weekDayLayout = itemView.findViewById<ConstraintLayout>(R.id.weekDayLayout)

        fun bind(day: WeekDayEntity, isFirstItem: Boolean, isLastItem: Boolean) {
            applyWidthToScreen(isFirstItem, isLastItem)
            dayOfWeek.text = day.dayOfWeek
//            dayAndMonth.text = "${day.monthTitle}\n${day.dayOfMonth}"
//            city.text = day.city
            itemView.setOnClickListener {
                weekDayClickListener.onDayClicked(day)
            }
        }

        private fun applyWidthToScreen(isFirstItem: Boolean, isLastItem: Boolean) {
            weekDayLayout.layoutParams.width = (ScreenSizeUtil.getWidth() - ScreenSizeUtil.getWidth()/4)
            val marginLayoutParams = MarginLayoutParams(weekDayLayout.layoutParams)
            marginLayoutParams.setMargins(
                if(isFirstItem) ScreenSizeUtil.getWidth()/8 else 0,
                0,
                if(isLastItem) ScreenSizeUtil.getWidth()/8 else 0,
                0
            )
            this.weekDayLayout.layoutParams = marginLayoutParams
        }
    }

    interface WeekDayClickListener {
        fun onDayClicked(weekDayEntity: WeekDayEntity)
    }

}