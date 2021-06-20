package linc.com.weatherapp.ui.main

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import linc.com.weatherapp.domain.usecases.GetCurrentWeatherUseCase
import linc.com.weatherapp.domain.usecases.GetDailyForecastUseCase
import linc.com.weatherapp.ui.base.BaseViewModel

class MainForecastViewModel(
    private val getDailyForecastUseCase: GetDailyForecastUseCase,
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase
) : BaseViewModel() {

    private val _currentForecastState = MutableStateFlow<Any?>(null)
    val currentForecastState: StateFlow<Any?> = _currentForecastState

    fun getData() {
        viewModelScope.launch {
            getCurrentWeatherUseCase(GetCurrentWeatherUseCase.Params())
                .flowOn(Dispatchers.IO)
                .catch {
                    print(it.localizedMessage)
                }
                .onEach { println(it) }
                .collect()

            getDailyForecastUseCase(GetDailyForecastUseCase.Params())
                .flowOn(Dispatchers.IO)
                .catch {
                    print(it.localizedMessage)
                }
                .onEach { println(it) }
                .collect()

        }
    }

}