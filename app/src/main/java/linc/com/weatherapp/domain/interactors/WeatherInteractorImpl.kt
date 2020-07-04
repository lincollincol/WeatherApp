package linc.com.weatherapp.domain.interactors

import linc.com.weatherapp.data.WeatherRepository

class WeatherInteractorImpl(
    private val weatherRepository: WeatherRepository
) {

    fun getWeather() {
        // use preference to get city for repository request


        weatherRepository.getWeather("Lviv")

    }



}