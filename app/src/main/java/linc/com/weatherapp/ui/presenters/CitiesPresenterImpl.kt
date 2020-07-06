package linc.com.weatherapp.ui.presenters

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import linc.com.weatherapp.domain.interactors.LocationInteractorImpl

class CitiesPresenterImpl(
    private val locationInteractorImpl: LocationInteractorImpl
) {

    fun getCountries() {
        locationInteractorImpl.getAllCountries()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }

    fun getCities() {

    }

}