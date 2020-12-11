package linc.com.weatherapp.ui.presenters

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import linc.com.weatherapp.domain.interactors.LocationInteractorImpl
import linc.com.weatherapp.ui.view.NewCityView

class NewCityPresenter(
    private var interactor: LocationInteractorImpl
) {

    private var view: NewCityView? = null

    fun bind(view: NewCityView) {
        this.view = view
    }

    fun unbind() {
        this.view = null
    }

    fun searchCountries(query: String) {
        interactor.filterCountries(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view?.updateCountries(it)
            }, Throwable::printStackTrace)
    }

    fun searchCities(country: String, query: String) {
        interactor.filterCities(country, query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }

}