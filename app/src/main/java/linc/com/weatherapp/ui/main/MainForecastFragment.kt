package linc.com.weatherapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder
import com.github.matteobattilana.weather.PrecipType
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import linc.com.weatherapp.databinding.FragmentMainForecastBinding
import linc.com.weatherapp.ui.main.items.DailyItem
import linc.com.weatherapp.utils.TimestampFormatter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainForecastFragment : Fragment() {

    private lateinit var mainForecastBinding: FragmentMainForecastBinding
    private val mainForecastViewModel: MainForecastViewModel by viewModel()
    private val dailyGroupAdapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mainForecastBinding = FragmentMainForecastBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@MainForecastFragment
            viewModel = mainForecastViewModel
            formatter = TimestampFormatter
        }
        return mainForecastBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainForecastBinding.forecastDaily.adapter = dailyGroupAdapter

        mainForecastViewModel.getData()
        lifecycleScope.launch {
            mainForecastViewModel.dailyItemsState.collect {
                dailyGroupAdapter.addAll(it.map { daily -> DailyItem(daily) })
            }
        }

    }

}
