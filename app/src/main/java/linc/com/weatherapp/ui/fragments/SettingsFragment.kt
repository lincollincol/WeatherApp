package linc.com.weatherapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_settings.*

import linc.com.weatherapp.R
import linc.com.weatherapp.domain.entities.SettingsOptionEntity
import linc.com.weatherapp.ui.activities.templates.MotionActivity
import linc.com.weatherapp.ui.adapters.SettingsOptionsAdapter

class SettingsFragment : Fragment(R.layout.fragment_settings), View.OnClickListener {

    companion object {
        fun newInstance() = SettingsFragment()
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

        settingsOptionsRecyclerView.apply {
            adapter = SettingsOptionsAdapter().apply {
                updateTimeWeathers(mutableListOf<SettingsOptionEntity>().apply {
                    repeat(6) {
                        add(SettingsOptionEntity(
                            "Settings $it",
                            when {
                                it < 3 -> SettingsOptionEntity.TOGGLE
                                else -> SettingsOptionEntity.TEXT
                            },
                            it == 2,
                            "Value $it"
                        ))
                    }
                })
            }
            layoutManager = LinearLayoutManager(view.context)
            setHasFixedSize(true)
        }

        backButton.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id) {
            R.id.backButton -> requireActivity().supportFragmentManager.popBackStack()
        }
    }

}
