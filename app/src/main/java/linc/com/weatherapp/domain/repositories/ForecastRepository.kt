package linc.com.weatherapp.domain.repositories

import kotlinx.coroutines.flow.Flow
import linc.com.weatherapp.domain.entities.weather.CurrentWeatherEntity
import linc.com.weatherapp.domain.entities.weather.DailyWeatherEntity
import linc.com.weatherapp.domain.entities.weather.TodayWeatherEntity

interface ForecastRepository {

    fun getCurrentForecast() : Flow<CurrentWeatherEntity>
    fun getDailyForecast() : Flow<List<DailyWeatherEntity>>
    fun getTodayForecast() : Flow<List<TodayWeatherEntity>>

}