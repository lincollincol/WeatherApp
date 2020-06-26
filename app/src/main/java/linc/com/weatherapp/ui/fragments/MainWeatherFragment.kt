package linc.com.weatherapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.PagerSnapHelper
import kotlinx.android.synthetic.main.fragment_main_weather.*
import linc.com.weatherapp.R
import linc.com.weatherapp.custom.CenterZoomLinearLayoutManager
import linc.com.weatherapp.domain.entities.WeekDayEntity
import linc.com.weatherapp.ui.adapters.WeekDaysAdapter

class MainWeatherFragment : Fragment(R.layout.fragment_main_weather) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        weekDays.apply {
            adapter = WeekDaysAdapter().apply {
                updateDays(mutableListOf<WeekDayEntity>().apply {
                    repeat(5) { index ->
                        add(WeekDayEntity("Monday $index", "Apr", index+10, "Lviv"))
                    }
                })
            }
            layoutManager = CenterZoomLinearLayoutManager(view.context)
        }

        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(weekDays)

    }

}