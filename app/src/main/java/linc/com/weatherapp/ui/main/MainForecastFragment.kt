package linc.com.weatherapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import linc.com.weatherapp.R
import linc.com.weatherapp.databinding.FragmentMainForecastBinding
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainForecastFragment : Fragment() {

    private lateinit var mainForecastBinding: FragmentMainForecastBinding
    private val mainForecastViewModel: MainForecastViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mainForecastBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main_forecast, container, false)
        return mainForecastBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainForecastViewModel.getData()
    }

}
