package linc.com.weatherapp.data.repository

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import linc.com.weatherapp.data.network.LocationApi
import linc.com.weatherapp.data.network.WeatherApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class LocationRepository(
    private val locationApi: LocationApi
) {

    fun getCity() {
        val gson = GsonBuilder().create()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("https://shivammathur.com")
            .build()

        retrofit.create(
                LocationApi::class.java
        ).apply {
            Completable.create {
                try {
                    val response = getCountryCities("ukraine").execute()
                    println("CITIES = ${response.body()}")
                    it.onComplete()
                }catch (e : Exception) {
                    it.onError(e)
                }
            }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({}, Throwable::printStackTrace)
        }
    }

    fun getAllCountries() : Single<List<String>> {
        return Single.fromCallable {
            locationApi.getCountries().execute().body()
        }
    }

    fun getCountryCities(country: String) : Single<List<String>> {
        return Single.fromCallable {
            locationApi.getCountries().execute().body()
        }
    }

}