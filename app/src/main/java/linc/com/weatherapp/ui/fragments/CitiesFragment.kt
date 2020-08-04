package linc.com.weatherapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_cities.*
import kotlinx.android.synthetic.main.fragment_cities.backButton

import linc.com.weatherapp.R
import linc.com.weatherapp.domain.entities.CityEntity
import linc.com.weatherapp.ui.activities.templates.MotionActivity
import linc.com.weatherapp.ui.adapters.CitiesAdapter
import linc.com.weatherapp.ui.dialogs.NewCityDialog
import linc.com.weatherapp.ui.view.CitiesView

class CitiesFragment : Fragment(R.layout.fragment_cities), CitiesView, View.OnClickListener {

    private lateinit var citiesAdapter: CitiesAdapter

    companion object {
        fun newInstance() = CitiesFragment()
    }

    override fun onStart() {
        super.onStart()
        (activity as MotionActivity).enableDragView(false)
    }

    override fun onStop() {
        super.onStop()
        (activity as MotionActivity).enableDragView(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        citiesAdapter = CitiesAdapter()

        citiesRecyclerView.apply {
            adapter = citiesAdapter
            layoutManager = LinearLayoutManager(view.context)
        }

        backButton.setOnClickListener(this)
        addCity.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.backButton -> requireActivity().supportFragmentManager.popBackStack()
            R.id.addCity -> {
                val newCityDialog = NewCityDialog()
                newCityDialog.show(requireActivity().supportFragmentManager, "TAG")
            }
        }
    }

    override fun showCountries(countries: List<String>) {
        TODO("Not yet implemented")
    }

    override fun showCities(cities: List<String>) {
        TODO("Not yet implemented")
    }

    override fun showSavedCities(cities: List<String>) {
        citiesAdapter.updateCities(cities.map {
            CityEntity(it, false)
        })
    }

}
