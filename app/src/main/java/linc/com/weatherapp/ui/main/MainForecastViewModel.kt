package linc.com.weatherapp.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import linc.com.weatherapp.domain.usecases.GetWeekForecastUseCase

class MainForecastViewModel(
    private val getWeekForecastUseCase: GetWeekForecastUseCase
) : ViewModel() {

    fun getData() {
        CoroutineScope(Dispatchers.IO).launch {
            getWeekForecastUseCase(GetWeekForecastUseCase.Params())
        }
//        viewModelScope.launch {
//        }
    }

}