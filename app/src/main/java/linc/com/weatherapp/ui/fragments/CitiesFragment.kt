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

class CitiesFragment : Fragment(R.layout.fragment_cities), View.OnClickListener {

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

        citiesRecyclerView.apply {
            adapter = CitiesAdapter().apply {
                updateTimeWeathers(mutableListOf<CityEntity>().apply {
                    repeat(3) {
                        add(CityEntity("City $it", it == 1))
                    }
                })
            }
            layoutManager = LinearLayoutManager(view.context)
        }

        backButton.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id) {
            R.id.backButton -> requireActivity().supportFragmentManager.popBackStack()
        }
    }

}
