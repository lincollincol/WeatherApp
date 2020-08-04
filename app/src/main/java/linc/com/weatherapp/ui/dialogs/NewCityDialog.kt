package linc.com.weatherapp.ui.dialogs

import android.graphics.Point
import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.dialog_new_city.*
import linc.com.weatherapp.R
import linc.com.weatherapp.ui.view.NewCityView
import linc.com.weatherapp.utils.updateOptions


class NewCityDialog : DialogFragment(), NewCityView {

    override fun onStart() {
        super.onStart()
        val window: Window? = dialog!!.window
        val size = Point()
        val display: Display = window!!.windowManager.defaultDisplay

        display.getSize(size)
        window.setLayout((size.x * 0.9).toInt(), (size.y * 0.5).toInt())
        window.setGravity(Gravity.CENTER)
        window.setBackgroundDrawable(ContextCompat.getDrawable(
            requireContext(),
            R.drawable.background_dialog_round_corners
        ))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.dialog_new_city, container, false)

    override fun updateCountries(countries: List<String>) {
        countryField.updateOptions(countries)
    }

    override fun updateCities(cities: List<String>) {
        cityField.updateOptions(cities)
    }

}