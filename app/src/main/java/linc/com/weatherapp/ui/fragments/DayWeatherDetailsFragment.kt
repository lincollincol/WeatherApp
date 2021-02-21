package linc.com.weatherapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.AutoTransition
import kotlinx.android.synthetic.main.fragment_day_weather_details.*
import linc.com.weatherapp.R
import linc.com.weatherapp.custom.FixedStartSnapHelper
import linc.com.weatherapp.domain.entities.WeekDayEntity
import linc.com.weatherapp.ui.activities.templates.MotionActivity
import linc.com.weatherapp.ui.adapters.TimeWeatherAdapter
import linc.com.weatherapp.utils.Constants
import linc.com.weatherapp.utils.Constants.WEEK_DAY_KEY
import linc.com.weatherapp.utils.ScreenSizeUtil

class DayWeatherDetailsFragment : Fragment(R.layout.fragment_day_weather_details),
    View.OnClickListener {

    companion object {
        fun newInstance(weekDayEntity: WeekDayEntity) = DayWeatherDetailsFragment().apply {
            arguments = Bundle().apply {
                putParcelable(WEEK_DAY_KEY, weekDayEntity)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = AutoTransition().apply {
            duration = 700
        }
        sharedElementReturnTransition = AutoTransition().apply {
            duration = 700
        }
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
        val day = requireArguments().getParcelable<WeekDayEntity>(WEEK_DAY_KEY)
        println("_______________________________WEEK_DAY = $day")

        currentWeatherAnimation.layoutParams.apply {
            height = ScreenSizeUtil.getWidth()/2
            width = ScreenSizeUtil.getWidth()/2
        }

        weatherDuringDayRecyclerView.apply {
            layoutParams.height = ScreenSizeUtil.getHeight()/3
            adapter = TimeWeatherAdapter().apply {
                updateTimeWeathers(requireArguments()
                    .getParcelable<WeekDayEntity>(WEEK_DAY_KEY)?.timeWeatherDetails ?: emptyList()
                )
            }
            layoutManager = LinearLayoutManager(view.context)
        }
        val fixedStartSnapHelper = FixedStartSnapHelper()
        fixedStartSnapHelper.attachToRecyclerView(weatherDuringDayRecyclerView)


        backButton.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id) {
            R.id.backButton -> requireActivity().supportFragmentManager.popBackStack()
        }
    }

}