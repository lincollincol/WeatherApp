package linc.com.weatherapp.ui.main

import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import linc.com.weatherapp.domain.entities.CurrentWeatherEntity
import linc.com.weatherapp.domain.entities.DailyWeatherEntity
import linc.com.weatherapp.domain.usecases.GetCurrentWeatherUseCase
import linc.com.weatherapp.domain.usecases.GetDailyForecastUseCase
import linc.com.weatherapp.ui.base.BaseViewModel

class MainForecastViewModel(
    private val getDailyForecastUseCase: GetDailyForecastUseCase,
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase
) : BaseViewModel() {

    private val _currentForecastState = MutableStateFlow<CurrentWeatherEntity?>(null)
    val currentForecastState = _currentForecastState.asLiveData()

    private val _dailyItemsState = MutableStateFlow<List<DailyWeatherEntity>>(mutableListOf())
    val dailyItemsState: StateFlow<List<DailyWeatherEntity>> = _dailyItemsState

    fun getData() {
        viewModelScope.launch {
            getCurrentWeatherUseCase(GetCurrentWeatherUseCase.Params())
                .flowOn(Dispatchers.IO)
                .catch {
                    print(it.localizedMessage)
                }
                .collect {
                    print("=============== current weather $it")
                    _currentForecastState.value = it
                }

            getDailyForecastUseCase(GetDailyForecastUseCase.Params())
                .flowOn(Dispatchers.IO)
                .catch {
                    print(it.localizedMessage)
                }
                .collect {
                    print(it)
                    _dailyItemsState.value = it
                }
        }
    }

}