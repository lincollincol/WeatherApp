package linc.com.weatherapp.ui.activities

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Transition
import android.view.View
import android.view.ViewTreeObserver
import androidx.constraintlayout.motion.widget.MotionLayout
import kotlinx.android.synthetic.main.activity_main.*
import linc.com.weatherapp.R
import linc.com.weatherapp.ui.activities.templates.MenuActivity
import linc.com.weatherapp.ui.activities.templates.MotionActivity
import linc.com.weatherapp.ui.fragments.CitiesFragment
import linc.com.weatherapp.ui.fragments.templates.ScreenConfigurationFragment
import linc.com.weatherapp.ui.fragments.MainWeatherFragment
import linc.com.weatherapp.ui.fragments.SettingsFragment
import linc.com.weatherapp.utils.Constants
import linc.com.weatherapp.utils.Constants.Companion.CITIES_MENU_OPTION
import linc.com.weatherapp.utils.Constants.Companion.SETTINGS_MENU_OPTION
import linc.com.weatherapp.utils.Constants.Companion.WEATHER_MENU_OPTION
import linc.com.weatherapp.utils.ProgressRounder
import linc.com.weatherapp.utils.ScreenSizeUtil

class MainActivity : AppCompatActivity(),
    MotionActivity,
    MenuActivity {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .replace(R.id.fragmentContainer, MainWeatherFragment.newInstance())
            .commit()

        menuButton.setOnClickListener {
            mainMotionLayout.transitionToEnd()
        }

    }

    override fun onConfigurationChanged(newConfig: Configuration) {
//        ScreenSizeUtil.calculateSize()
//        (supportFragmentManager.findFragmentById(R.id.fragmentContainer) as? ScreenConfigurationFragment)
//            ?.onFragmentConfigurationChanged()
        super.onConfigurationChanged(newConfig)
    }

    override fun enableDragView(enable: Boolean) {
        openMenuDragView.visibility = when(enable) {
            true -> View.VISIBLE
            else -> View.GONE
        }
        menuButton.visibility = openMenuDragView.visibility
    }

    override fun onMenuOptionSelected(option: Byte) {
        supportFragmentManager.beginTransaction().apply {
            setReorderingAllowed(true)
            replace(R.id.fragmentContainer, when(option) {
                CITIES_MENU_OPTION -> CitiesFragment.newInstance()
                SETTINGS_MENU_OPTION -> SettingsFragment.newInstance()
                else -> MainWeatherFragment.newInstance()
            })
            if(option != WEATHER_MENU_OPTION) addToBackStack(null)
            commit()
        }
        mainMotionLayout.transitionToStart()
    }

}
