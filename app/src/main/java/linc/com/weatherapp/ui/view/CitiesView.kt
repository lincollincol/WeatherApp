package linc.com.weatherapp.ui.view

interface CitiesView {

    fun showCountries(countries: List<String>)
    fun showCities(cities: List<String>)

    fun showSavedCities(cities: List<String>)

}