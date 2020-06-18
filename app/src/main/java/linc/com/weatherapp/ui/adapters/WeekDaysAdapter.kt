package linc.com.weatherapp.ui.adapters

import android.content.Context
import android.graphics.Point
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import linc.com.weatherapp.R
import linc.com.weatherapp.domain.entities.WeekDayEntity


class WeekDaysAdapter : RecyclerView.Adapter<WeekDaysAdapter.WeekDayViewHolder>() {

    private val days = mutableListOf<WeekDayEntity>()

    fun updateDays(days: List<WeekDayEntity>) {
//        val diffResult = DiffUtil.calculateDiff(DaysDiffCallback(this.days, days))
//        diffResult.dispatchUpdatesTo(this)
        this.days.clear()
        this.days.addAll(days)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = WeekDayViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_day_weather, parent, false)
    )

    override fun onBindViewHolder(holder: WeekDayViewHolder, position: Int) {
        holder.bind(days[position])
    }

    override fun getItemCount() = days.count()

    inner class WeekDayViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private val dayOfWeek = itemView.findViewById<TextView>(R.id.dayOfWeek)
        private val dayAndMonth = itemView.findViewById<TextView>(R.id.dayAndMonth)
        private val city = itemView.findViewById<TextView>(R.id.city)
        private val weekDayLayout = itemView.findViewById<ConstraintLayout>(R.id.weekDayLayout)

        fun bind(day: WeekDayEntity) {
            applyWidthToScreen()
            dayOfWeek.text = day.dayOfWeek
            dayAndMonth.text = "${day.monthTitle}\n${day.dayOfMonth}"
            city.text = day.city
        }

        fun applyWidthToScreen() {
            val display = (itemView.context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay
            val size = Point()
            display.getSize(size)

            val width: Int = size.x
            val height: Int = size.y

            weekDayLayout.layoutParams.width = (width - width/4)

        }
    }

}