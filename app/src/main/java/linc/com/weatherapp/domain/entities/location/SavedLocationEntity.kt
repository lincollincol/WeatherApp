package linc.com.weatherapp.domain.entities.location

data class SavedLocationEntity(
    val name: String,
    val current: Boolean,
    val latitude: Double,
    val longitude: Double,
)
