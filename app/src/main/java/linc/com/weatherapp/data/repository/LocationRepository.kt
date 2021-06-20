package linc.com.weatherapp.data.repository


class LocationRepository(
) {

  /*  fun getCity() {
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
*/
}