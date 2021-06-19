package linc.com.weatherapp.di

import linc.com.weatherapp.ui.main.MainForecastViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val mainForecastModule = module {

    viewModel { MainForecastViewModel(getWeekForecastUseCase = get()) }

}
