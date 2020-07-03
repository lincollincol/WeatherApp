package linc.com.weatherapp.data

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import linc.com.weatherapp.data.network.WeatherApi

class WeatherRepository(
    private val weatherApi: WeatherApi
) {

    fun getWeather(city: String) {
        /*Single.fromCallable {
            weatherApi.getCurrentWeatherData("d183e48c4ae3b24a8f0d829f452950be").execute()
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.body().currentWeather.forEach { weather ->
                    println("____________________________-WEATHER_DESCRIPTION = ${weather.description}")
                }
            }, {
                it.printStackTrace()
            })
*/
        // getForecastData
        /*Single.fromCallable {
            weatherApi.getForecastData(7, "d183e48c4ae3b24a8f0d829f452950be").execute()
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.body().list.forEach { weather ->
                    println("____________________________-WEATHER_TEMPERATURE = ${weather.main.temp}")
                }
            }, {
                it.printStackTrace()
            })*/

//        getDailyData

        Single.fromCallable {
            weatherApi.getDailyData("d183e48c4ae3b24a8f0d829f452950be").execute()
//            weatherApi.getDailyData().execute()
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.body().daily.forEach { weather ->
                    println("____________________________-WEATHER_TEMPERATURE = ${weather.temp.day}")
                }
            }, {
                it.printStackTrace()
            })
    }

    fun getCityCoordinates(cityTitle: String) {
        Single.fromCallable {
            weatherApi.getCurrentWeatherData(cityTitle,"d183e48c4ae3b24a8f0d829f452950be").execute()
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                when(it.isSuccessful) {
                    true -> {
//                        it.body().currentCoord.lat
//                        it.body().currentCoord.lon
                        println("_____________CITY_COORDINATES_FOUND = [lat = ${it.body().currentCoord.lat}; lon = ${it.body().currentCoord.lon}]")
                    }
                    else -> {
                        println("_____________CITY_NOT_FOUND")
                    }
                }

            }, {
                it.printStackTrace()
            })
    }

    fun getDailyForecastByCity(cityTitle: String) {
        Single.fromCallable {
            weatherApi.getCurrentWeatherData(cityTitle, "d183e48c4ae3b24a8f0d829f452950be").execute()
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                when(it.isSuccessful) {
                    true -> {
//                        it.body().currentCoord.lat
//                        it.body().currentCoord.lon
                        println("_____________CITY_COORDINATES_FOUND = [lat = ${it.body().currentCoord.lat}; lon = ${it.body().currentCoord.lon}]")
                    }
                    else -> {
                        println("_____________CITY_NOT_FOUND")
                    }
                }

            }, {
                it.printStackTrace()
            })

        Single.fromCallable {
            weatherApi.getCurrentWeatherData(cityTitle, "d183e48c4ae3b24a8f0d829f452950be").execute()
        }.subscribeOn(Schedulers.io())
            .subscribe({
                when(it.isSuccessful) {
                    true -> {
//                        it.body().currentCoord.lat
//                        it.body().currentCoord.lon
                        val response = weatherApi.getDailyForecastByCity(
                            it.body().currentCoord.lat,
                            it.body().currentCoord.lon,
                            "d183e48c4ae3b24a8f0d829f452950be"
                        ).execute()

                        println("_____________RESULT_DAILY_BY_COORD = ${response.body().timezone}")
                    }
                    else -> {
                        println("_____________CITY_NOT_FOUND")
                    }
                }
            }, {
                it.printStackTrace()
            })
    }


}