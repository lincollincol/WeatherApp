package linc.com.weatherapp.ui.location

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import linc.com.weatherapp.databinding.FragmentLocationBinding
import linc.com.weatherapp.databinding.FragmentMainForecastBinding
import linc.com.weatherapp.domain.entities.location.SavedLocationEntity
import linc.com.weatherapp.ui.base.BaseFragment
import linc.com.weatherapp.ui.location.items.SavedLocationItem
import linc.com.weatherapp.ui.main.MainForecastViewModel
import linc.com.weatherapp.utils.AdapterClickListener
import linc.com.weatherapp.utils.TimestampFormatter
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationFragment : BaseFragment(), AdapterClickListener<SavedLocationEntity> {

    private lateinit var locationBinding: FragmentLocationBinding
    private val locationViewModel: LocationViewModel by viewModel()
    private val locationsAdapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        locationBinding = FragmentLocationBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@LocationFragment
            viewModel = locationViewModel
        }
        return locationBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items = mutableListOf<SavedLocationItem>().apply {
            repeat(10) {
                add(SavedLocationItem(SavedLocationEntity(
                    "Lviv #$it, Ukraine",
                    true,
                    0.0,
                    0.0
                ), this@LocationFragment))
            }
        }

        locationsAdapter.addAll(items)

        locationBinding.locations.adapter = locationsAdapter

    }

    override fun onItemClick(item: SavedLocationEntity) {
        println("Clicked: ")
        println(item)
    }

}