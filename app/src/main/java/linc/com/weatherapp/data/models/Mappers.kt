package linc.com.weatherapp.data.models

import linc.com.weatherapp.data.models.response.weather.ForecastResponse
import linc.com.weatherapp.data.models.response.weather.TodayWeatherResponse
import linc.com.weatherapp.domain.entities.weather.CurrentWeatherEntity
import linc.com.weatherapp.domain.entities.weather.DailyWeatherEntity
import linc.com.weatherapp.domain.entities.weather.TodayWeatherEntity
import linc.com.weatherapp.utils.Constants.UNKNOWN_PLACEHOLDER
import linc.com.weatherapp.utils.Constants.WEATHER_ICON_DEFAULT
import linc.com.weatherapp.utils.Constants.WEATHER_ICON_FORMAT
import linc.com.weatherapp.utils.Constants.WEATHER_ICON_URL
import linc.com.weatherapp.utils.Constants.WEATHER_ICON_2X_ZOOM
import linc.com.weatherapp.utils.Constants.WEATHER_ICON_4X_ZOOM

fun TodayWeatherResponse.toWeatherEntities() = listOf(
    *todayForecast.map { forecastItem -> TodayWeatherEntity(
        forecastItem.dt,
        forecastItem.weather.firstOrNull()?.main ?: UNKNOWN_PLACEHOLDER,
        forecastItem.weather.firstOrNull()?.description ?: UNKNOWN_PLACEHOLDER,
        formatUrl(forecastItem.weather.firstOrNull()?.icon),
        forecastItem.main.tempMax,
        forecastItem.main.tempMin,
        forecastItem.main.temp,
        forecastItem.main.feelsLike,
        forecastItem.main.pressure,
        forecastItem.main.humidity,
        forecastItem.main.seaLevel,
        forecastItem.main.grndLevel,
        forecastItem.clouds.all,
        forecastItem.wind.deg,
        forecastItem.wind.speed
    )
    }.toTypedArray()
)

fun ForecastResponse.toDailyWeatherEntities() = listOf(
    *daily.map { dailyItem -> DailyWeatherEntity(
        dailyItem.dt,
        dailyItem.weather.firstOrNull()?.main ?: UNKNOWN_PLACEHOLDER,
        dailyItem.weather.firstOrNull()?.description ?: UNKNOWN_PLACEHOLDER,
        formatUrl(dailyItem.weather.firstOrNull()?.icon),
        dailyItem.temp.max,
        dailyItem.temp.min,
        dailyItem.clouds
    )
    }.toTypedArray()
)

fun ForecastResponse.toCurrentWeatherEntity() = CurrentWeatherEntity(
    current.dt,
    current.weather.firstOrNull()?.main ?: UNKNOWN_PLACEHOLDER,
    current.weather.firstOrNull()?.description ?: UNKNOWN_PLACEHOLDER,
    formatUrl(current.weather.firstOrNull()?.icon, WEATHER_ICON_4X_ZOOM),
    current.temp,
    current.humidity,
    current.clouds,
    current.windDeg,
    current.windSpeed
)

private fun formatUrl(icon: String?, preferredZoom: String = WEATHER_ICON_2X_ZOOM) =
    "$WEATHER_ICON_URL${icon ?: WEATHER_ICON_DEFAULT}@$preferredZoom.$WEATHER_ICON_FORMAT"