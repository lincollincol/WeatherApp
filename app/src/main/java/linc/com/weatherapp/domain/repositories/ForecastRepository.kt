package linc.com.weatherapp.domain.repositories

import kotlinx.coroutines.flow.Flow
import linc.com.weatherapp.domain.entities.CurrentWeatherEntity
import linc.com.weatherapp.domain.entities.DailyWeatherEntity
import linc.com.weatherapp.domain.entities.TodayWeatherEntity
import linc.com.weatherapp.domain.entities.WeatherEntity

interface ForecastRepository {

    fun getCurrentForecast() : Flow<CurrentWeatherEntity>
    fun getDailyForecast() : Flow<List<DailyWeatherEntity>>
    fun getTodayForecast() : Flow<List<TodayWeatherEntity>>

}