package linc.com.weatherapp.ui.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.PagerSnapHelper
import kotlinx.android.synthetic.main.fragment_main_weather.*
import linc.com.weatherapp.R
import linc.com.weatherapp.custom.CenterZoomLinearLayoutManager
import linc.com.weatherapp.domain.entities.WeekDayEntity
import linc.com.weatherapp.ui.adapters.WeekDaysAdapter
import linc.com.weatherapp.ui.callbacks.ScreenConfigurationFragment
import linc.com.weatherapp.utils.ScreenSizeUtil

class MainWeatherFragment : Fragment(R.layout.fragment_main_weather),
    ScreenConfigurationFragment {

    private lateinit var weekDaysAdapter: WeekDaysAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        weekDaysAdapter = WeekDaysAdapter().apply {
            updateDays(mutableListOf<WeekDayEntity>().apply {
                repeat(5) { index ->
                    add(WeekDayEntity("Monday $index", "Apr", index+10, "Lviv"))
                }
            })
        }

        weekDays.apply {
            layoutParams.height = ScreenSizeUtil.getHeight()/4
            adapter = weekDaysAdapter
            layoutManager = CenterZoomLinearLayoutManager(view.context)
        }

        currentTemperature.setOnClickListener {
            println("_________________________________________CURRENT_WIDTH = ${ScreenSizeUtil.getWidth()}")
        }

        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(weekDays)

        println("_________________________________________CREATED")
    }

    override fun onFragmentConfigurationChanged() {
        println("_________________________________________CHANGED")
        println("_________________________________________WIDTH = ${ScreenSizeUtil.getWidth()}")
        weekDaysAdapter.refresh()

    }

}