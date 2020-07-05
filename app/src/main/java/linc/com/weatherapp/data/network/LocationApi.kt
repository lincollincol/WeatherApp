package linc.com.weatherapp.data.network

import linc.com.weatherapp.data.models.response.location.CitiesApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface LocationApi {

    //https://shivammathur.com/countrycity/cities/ukraine
    @GET("/countrycity/cities/{country}")
    fun getCountryCities(
        @Path("country") country: String
    ) : Call<Object>
//    ) : Call<CitiesApiResponse>

}