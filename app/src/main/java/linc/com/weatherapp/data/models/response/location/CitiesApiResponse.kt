package linc.com.weatherapp.data.models.response.location

import com.google.gson.annotations.Expose

class CitiesApiResponse(
    @Expose val cities: List<String>
)