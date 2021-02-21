package linc.com.weatherapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_menu.*
import linc.com.weatherapp.R
import linc.com.weatherapp.ui.activities.templates.MenuActivity
import linc.com.weatherapp.utils.Constants.CITIES_MENU_OPTION
import linc.com.weatherapp.utils.Constants.SETTINGS_MENU_OPTION
import linc.com.weatherapp.utils.Constants.WEATHER_MENU_OPTION

class MenuFragment : Fragment(R.layout.fragment_menu), View.OnClickListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        weatherMenuOption.setOnClickListener(this)
        cityMenuOption.setOnClickListener(this)
        settingsMenuOption.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id) {
            R.id.weatherMenuOption -> (activity as MenuActivity).onMenuOptionSelected(WEATHER_MENU_OPTION)
            R.id.cityMenuOption -> (activity as MenuActivity).onMenuOptionSelected(CITIES_MENU_OPTION)
            R.id.settingsMenuOption -> (activity as MenuActivity).onMenuOptionSelected(SETTINGS_MENU_OPTION)
        }
    }

}