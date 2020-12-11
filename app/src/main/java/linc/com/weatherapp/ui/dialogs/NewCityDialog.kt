package linc.com.weatherapp.ui.dialogs

import android.graphics.Point
import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.DialogFragment
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.dialog_new_city.*
import linc.com.weatherapp.R
import linc.com.weatherapp.data.network.LocationApi
import linc.com.weatherapp.data.repository.LocationRepository
import linc.com.weatherapp.domain.interactors.LocationInteractorImpl
import linc.com.weatherapp.ui.presenters.NewCityPresenter
import linc.com.weatherapp.ui.view.NewCityView
import linc.com.weatherapp.utils.State
import linc.com.weatherapp.utils.updateOptions
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewCityDialog : DialogFragment(), NewCityView, View.OnClickListener {

    private var presenter: NewCityPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val gson = GsonBuilder().create()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("https://shivammathur.com")
            .build()

        presenter = NewCityPresenter(
            LocationInteractorImpl(
                LocationRepository(retrofit.create(LocationApi::class.java))
            )
        )

        presenter?.bind(this)

    }

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        countryField.addTextChangedListener(onTextChanged = { text, _, _, _ ->
            presenter?.searchCountries(text.toString())
        })

        cityField.addTextChangedListener(onTextChanged = { text, _, _, _ ->
            presenter?.searchCities(countryField.text.toString(), text.toString())
        })

        confirm.setOnClickListener(this)
        close.setOnClickListener(this)
    }

    override fun updateCountries(countries: List<String>) {
        countryField.updateOptions(countries)
    }

    override fun updateCities(cities: List<String>) {
        cityField.updateOptions(cities)
    }

    override fun enableConfirm(state: State) {
        when(state) {
            State.DISABLE -> confirm.isEnabled = false
            State.ENABLE -> confirm.isEnabled = true
        }
    }

    override fun enableCityField(state: State) {
        when(state) {
            State.DISABLE -> cityField.isEnabled = false
            State.ENABLE -> cityField.isEnabled = true
        }
    }

    override fun onClick(p0: View?) {
        when(p0!!.id) {
            R.id.confirm -> {}
            R.id.close -> {}
        }
    }



}