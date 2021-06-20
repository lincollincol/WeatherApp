package linc.com.weatherapp.utils

object Constants {
    const val WEEK_DAY_KEY = "week_dey_key"

    // Menu
    const val WEATHER_MENU_OPTION: Byte = 0
    const val CITIES_MENU_OPTION: Byte = 1
    const val SETTINGS_MENU_OPTION: Byte = 2

    // Flags

    const val WEATHER_ICON_URL = "https://openweathermap.org/img/wn/"
    const val WEATHER_ICON_ZOOM = "2x"
    const val WEATHER_ICON_DEFAULT = "02d"
    const val WEATHER_ICON_FORMAT = "png"

    const val UNKNOWN_PLACEHOLDER = "Unknown"

    // https://openweathermap.org/img/wn/10d@2x.png
    // https://openweathermap.org/img/wn/ + <icon> + @ + <zoom> + .png

    // Background
    const val MORNING: Byte = 0
    const val AFTERNOON: Byte = 1
    const val EVENING: Byte = 2
    const val NIGHT: Byte = 3

    const val WINTER: Byte = 0
    const val SPRING: Byte = 1
    const val SUMMER: Byte = 2
    const val AUTUMN: Byte = 3

}