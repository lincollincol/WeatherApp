package linc.com.weatherapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.PagerSnapHelper
import com.airbnb.lottie.LottieAnimationView
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.fragment_main_weather.*
import linc.com.weatherapp.R
import linc.com.weatherapp.custom.CenterZoomLinearLayoutManager
import linc.com.weatherapp.data.repository.WeatherRepositoryImpl
import linc.com.weatherapp.data.network.WeatherApi
import linc.com.weatherapp.data.repository.LocationRepository
import linc.com.weatherapp.domain.entities.TimeWeatherEntity
import linc.com.weatherapp.domain.entities.WeekDayEntity
import linc.com.weatherapp.ui.adapters.WeekDaysAdapter
import linc.com.weatherapp.ui.fragments.templates.ScreenConfigurationFragment
import linc.com.weatherapp.utils.BackgroundProvider
import linc.com.weatherapp.utils.ScreenSizeUtil
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.random.Random

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

//        weatherBackground.setImageResource(R.drawable.andre)


        currentTemperature.setOnClickListener {
            weatherBackground.setImageResource(
                BackgroundProvider.getBackgroundResource(System.currentTimeMillis())
            )
        }


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

        weekDaysAdapter = WeekDaysAdapter().apply {
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
        snapHelper.attachToRecyclerView(weekDays)
    }

    override fun onFragmentConfigurationChanged() {
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
    }

}