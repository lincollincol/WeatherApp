package linc.com.weatherapp.data.models.response.weather

data class WeatherDetails(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)
