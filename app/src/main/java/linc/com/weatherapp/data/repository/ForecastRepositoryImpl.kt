package linc.com.weatherapp.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import linc.com.weatherapp.data.models.toCurrentWeatherEntity
import linc.com.weatherapp.data.models.toDailyWeatherEntities
import linc.com.weatherapp.data.models.toWeatherEntities
import linc.com.weatherapp.data.remote.api.ForecastApi
import linc.com.weatherapp.domain.entities.CurrentWeatherEntity
import linc.com.weatherapp.domain.entities.DailyWeatherEntity
import linc.com.weatherapp.domain.entities.TodayWeatherEntity
import linc.com.weatherapp.domain.repositories.ForecastRepository

class ForecastRepositoryImpl(
    private val forecastApi: ForecastApi
) : ForecastRepository {

    override fun getCurrentForecast(): Flow<CurrentWeatherEntity> = flow {
        emit(forecastApi.getForecast(
            50.0,
            50.0,
            "ua",
            "metric",
            "minutely,hourly,alerts",
            5,
            "d183e48c4ae3b24a8f0d829f452950be"
        ).toCurrentWeatherEntity())
    }

    override fun getDailyForecast(): Flow<List<DailyWeatherEntity>> = flow {
        emit(forecastApi.getForecast(
            50.0,
            50.0,
            "ua",
            "metric",
            "minutely,hourly,alerts",
            5,
            "d183e48c4ae3b24a8f0d829f452950be"
        ).toDailyWeatherEntities())
    }

    override fun getTodayForecast(): Flow<List<TodayWeatherEntity>> = flow {
        emit(forecastApi.getTodayForecast(
            "Lviv",
            "ua",
            "metric",
            5,
            "d183e48c4ae3b24a8f0d829f452950be"
        ).toWeatherEntities())
    }

}