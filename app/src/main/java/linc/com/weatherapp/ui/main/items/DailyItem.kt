package linc.com.weatherapp.ui.main.items

import android.view.View
import com.xwray.groupie.Item
import com.xwray.groupie.viewbinding.BindableItem
import linc.com.weatherapp.R
import linc.com.weatherapp.databinding.ItemDailyBinding
import linc.com.weatherapp.domain.entities.DailyWeatherEntity
import linc.com.weatherapp.utils.TimestampFormatter

class DailyItem(
    private val dailyWeatherEntity: DailyWeatherEntity
) : BindableItem<ItemDailyBinding>() {

    override fun bind(viewBinding: ItemDailyBinding, position: Int) {
        viewBinding.apply {
            data = dailyWeatherEntity
            formatter = TimestampFormatter
        }
    }

    override fun getLayout() = R.layout.item_daily

    override fun initializeViewBinding(view: View) = ItemDailyBinding.bind(view)
}