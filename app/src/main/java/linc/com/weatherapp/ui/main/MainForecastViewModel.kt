package linc.com.weatherapp.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import linc.com.weatherapp.domain.usecases.GetWeekForecastUseCase
import linc.com.weatherapp.ui.base.BaseViewModel

class MainForecastViewModel(
    private val getWeekForecastUseCase: GetWeekForecastUseCase
) : BaseViewModel() {

    private val _currentForecastState = MutableStateFlow<Any?>(null)
    val currentForecastState: StateFlow<Any?> = _currentForecastState

    fun getData() {
        viewModelScope.launch {
            getWeekForecastUseCase(GetWeekForecastUseCase.Params())
                .flowOn(Dispatchers.IO)
                .catch {
                    print(it.localizedMessage)
                }
                .onEach { println(it) }
                .collect()

        }
    }

}