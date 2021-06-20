package linc.com.weatherapp.di

import linc.com.weatherapp.domain.usecases.GetCurrentWeatherUseCase
import linc.com.weatherapp.domain.usecases.GetDailyForecastUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetDailyForecastUseCase(forecastRepository = get()) }
    factory { GetCurrentWeatherUseCase(forecastRepository = get()) }
}
