package linc.com.weatherapp.ui.activities

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import linc.com.weatherapp.R
import linc.com.weatherapp.ui.activities.templates.MotionActivity
import linc.com.weatherapp.ui.fragments.templates.ScreenConfigurationFragment
import linc.com.weatherapp.ui.fragments.MainWeatherFragment
import linc.com.weatherapp.utils.ScreenSizeUtil

class MainActivity : AppCompatActivity(),
    MotionActivity{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .replace(R.id.fragmentContainer, MainWeatherFragment.newInstance())
            .commit()

    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        ScreenSizeUtil.calculateSize()
        (supportFragmentManager.findFragmentById(R.id.fragmentContainer) as? ScreenConfigurationFragment)
            ?.onFragmentConfigurationChanged()
        super.onConfigurationChanged(newConfig)
    }

    override fun enableDragView(enable: Boolean) {
        openMenuDragView.visibility = when(enable) {
            true -> View.VISIBLE
            else -> View.GONE
        }
    }

}
