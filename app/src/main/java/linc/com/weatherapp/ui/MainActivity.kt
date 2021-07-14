package linc.com.weatherapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*
import linc.com.weatherapp.R
import linc.com.weatherapp.databinding.ActivityMainBinding
import linc.com.weatherapp.utils.hideStatusBar

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideStatusBar()

        activityMainBinding = DataBindingUtil.setContentView(
            this@MainActivity,
            R.layout.activity_main
        )

        activityMainBinding.background.apply {
            setOnPreparedListener {
                it.isLooping = true
            }
            setVideoRaw(R.raw.forest_result)
            start()
        }

        NavigationUI.setupWithNavController(
            activityMainBinding.bottomMenu,
            findNavController(R.id.nav_host_fragment)
        )
        activityMainBinding.bottomMenu.setOnNavigationItemReselectedListener {
            // Ignore reselected event
        }

    }


}
