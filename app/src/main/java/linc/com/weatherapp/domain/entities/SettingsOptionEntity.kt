package linc.com.weatherapp.domain.entities

data class SettingsOptionEntity(
    val optionTitle: String,
    val settingsType: Int,
    val checked: Boolean = false,
    val value: String = ""
) {
    companion object {
        const val TOGGLE = 0
        const val TEXT = 1
    }
}