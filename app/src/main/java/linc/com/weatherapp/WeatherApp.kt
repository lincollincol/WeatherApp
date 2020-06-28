package linc.com.weatherapp

import android.app.Application
import linc.com.weatherapp.utils.ScreenSizeUtil

class WeatherApp : Application() {
    override fun onCreate() {
        super.onCreate()
        ScreenSizeUtil.init(this)
    }
}