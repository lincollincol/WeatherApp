package linc.com.weatherapp.ui.viewmodels

import androidx.lifecycle.ViewModel

class WeekForecastViewModel : ViewModel() {

    fun getData() {
        println("RETRIEVE DATA")
    }

    override fun onCleared() {
        super.onCleared()
        println("CLEARED")
    }

}