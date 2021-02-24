package linc.com.weatherapp.ui.fragments

import android.R.drawable
import android.graphics.drawable.ScaleDrawable
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_main_weather.*
import kotlinx.android.synthetic.main.item_forecast_for_time.view.*
import linc.com.weatherapp.R
import linc.com.weatherapp.domain.entities.WeekDayEntity
import linc.com.weatherapp.ui.adapters.TimeForecastAdapter
import linc.com.weatherapp.ui.adapters.WeekDaysAdapter
import linc.com.weatherapp.ui.fragments.templates.ScreenConfigurationFragment


class MainWeatherFragment : Fragment(R.layout.fragment_main_weather),
    ScreenConfigurationFragment,
    WeekDaysAdapter.WeekDayClickListener {

    private lateinit var weekDaysAdapter: WeekDaysAdapter

    companion object {
        fun newInstance() = MainWeatherFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        todo: LocationRepository().getCity()
        val timeAdapter = TimeForecastAdapter().apply {
            setForecasts(mutableListOf(Object(), Object(), Object(), Object(), Object(), Object()))
        }

        todayForecast.apply {
//            layoutParams.height = ScreenSizeUtil.getHeight()/4
            adapter = timeAdapter
//            layoutManager = CenterZoomLinearLayoutManager(view.context)
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        }



    //        weatherBackground.setImageResource(R.drawable.andre)


        /*currentTemperature.setOnClickListener {
            weatherBackground.setImageResource(
                BackgroundProvider.getBackgroundResource(System.currentTimeMillis())
            )
        }*/


        /*val gson = GsonBuilder().create()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("http://api.openweathermap.org")
            .build()

        WeatherRepositoryImpl(
            retrofit.create(
                WeatherApi::class.java
            )
        ).apply {
//            getWeather("Nadvirna")
//            getCityCoordinates("Nadvirna")
//            getDailyForecastByCity("Nadvirna")
        }*/

        /*weekDaysAdapter = WeekDaysAdapter().apply {
            updateDays(mutableListOf<WeekDayEntity>().apply {
                repeat(5) { index ->
                    add(WeekDayEntity(
                        "Monday $index",
                        "Apr",
                        index+10,
                        "Lviv",
                        listOf(
                            TimeWeatherEntity("0$index:00", (index+20).toByte(), (index+10).toByte(), "Details $index"),
                            TimeWeatherEntity("1$index:30", (index+15).toByte(), (index+5).toByte(), "Details $index"),
                            TimeWeatherEntity("1$index:55", (index+10).toByte(), (index+2).toByte(), "Details $index"),
                            TimeWeatherEntity("1$index:20", (index+10).toByte(), (index+2).toByte(), "Details $index"),
                            TimeWeatherEntity("2$index:15", (index+10).toByte(), (index+2).toByte(), "Details $index")
                        )
                    ))
                }
            })
            setOnWeekDayClickListener(this@MainWeatherFragment)
        }

        weekDays.apply {
            layoutParams.height = ScreenSizeUtil.getHeight()/4
            adapter = weekDaysAdapter
            layoutManager = CenterZoomLinearLayoutManager(view.context)
        }

        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(weekDays)*/
    }


    /*override fun onFragmentConfigurationChanged() {
        weekDaysAdapter.refresh()
    }

    override fun onDayClicked(weekDayEntity: WeekDayEntity) {
        requireActivity().supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .addSharedElement(currentWeatherAnimation, currentWeatherAnimation.transitionName)
            .addSharedElement(currentTemperature, currentTemperature.transitionName)
            .replace(R.id.fragmentContainer, DayWeatherDetailsFragment.newInstance(weekDayEntity))
            .addToBackStack(null)
            .commit()
    }*/
    override fun onDayClicked(weekDayEntity: WeekDayEntity) {
    }

    override fun onFragmentConfigurationChanged() {
        TODO("Not yet implemented")
    }

}