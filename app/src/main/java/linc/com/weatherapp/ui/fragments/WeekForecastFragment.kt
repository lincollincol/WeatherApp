package linc.com.weatherapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import linc.com.weatherapp.R
import linc.com.weatherapp.ui.viewmodels.WeekForecastViewModel

class WeekForecastFragment : Fragment(R.layout.fragment_week_forecast) {

    lateinit var forecastViewModel: WeekForecastViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        forecastViewModel = ViewModelProvider(this).get(WeekForecastViewModel::class.java)


        forecastViewModel.getData()
    }

}