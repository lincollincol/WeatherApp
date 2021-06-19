package linc.com.weatherapp.domain.interactors

import linc.com.weatherapp.data.repository.LocationRepository

class LocationInteractorImpl(
    private val locationRepository: LocationRepository
) {
/*
    fun filterCountries(query: String) = locationRepository.getAllCountries()

    fun filterCities(country: String, query: String) = locationRepository.getCountryCities(country)
        .toObservable()
        .flatMap{ Observable.fromIterable(it) }
        .filter {
//            it.startsWith()
            it.contains(query)
        }
        .toList()

    fun getAllCountries() = locationRepository.getAllCountries()

    fun saveCity() {

    }*/

}