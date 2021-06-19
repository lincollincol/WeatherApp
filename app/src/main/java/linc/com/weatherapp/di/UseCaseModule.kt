package linc.com.weatherapp.di

import linc.com.weatherapp.domain.usecases.GetWeekForecastUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetWeekForecastUseCase(forecastRepository = get()) }
}
