package linc.com.weatherapp

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import linc.com.weatherapp.ui.callbacks.ScreenConfigurationFragment
import linc.com.weatherapp.utils.ScreenSizeUtil

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        ScreenSizeUtil.calculateSize()
        (supportFragmentManager.findFragmentById(R.id.mainWeatherFragment) as ScreenConfigurationFragment)
            .onFragmentConfigurationChanged()
        super.onConfigurationChanged(newConfig)
    }

}
