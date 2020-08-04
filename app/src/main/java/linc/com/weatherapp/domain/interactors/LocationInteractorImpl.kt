package linc.com.weatherapp.domain.interactors

import io.reactivex.rxjava3.core.Single
import linc.com.weatherapp.data.repository.LocationRepository

class LocationInteractorImpl(
    private val locationRepository: LocationRepository
) {

    fun getAllCountries() = locationRepository.getAllCountries()

    fun saveCity() {

    }

}