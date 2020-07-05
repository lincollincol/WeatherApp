package linc.com.weatherapp.domain.interactors

import linc.com.weatherapp.data.repository.WeatherRepositoryImpl

class WeatherInteractorImpl(
    private val weatherRepository: WeatherRepositoryImpl
) {

    fun getWeather() {
        // use preference to get city for repository request


        weatherRepository.getWeather("Lviv")

    }



}