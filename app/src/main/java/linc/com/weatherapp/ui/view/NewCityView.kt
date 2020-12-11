package linc.com.weatherapp.ui.view

import linc.com.weatherapp.utils.State

interface NewCityView {

    fun updateCountries(countries: List<String>)
    fun updateCities(cities: List<String>)
    fun enableConfirm(state: State)
    fun enableCityField(state: State)

}