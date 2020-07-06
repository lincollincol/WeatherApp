package linc.com.weatherapp.data.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface LocationApi {

    @GET("/countrycity/countries")
    fun getCountries() : Call<ArrayList<String>>

    @GET("/countrycity/cities/{country}")
    fun getCountryCities(
        @Path("country") country: String
    ) : Call<ArrayList<String>>

}