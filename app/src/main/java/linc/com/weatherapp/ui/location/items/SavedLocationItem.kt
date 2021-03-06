package linc.com.weatherapp.ui.location.items

import android.view.View
import com.xwray.groupie.viewbinding.BindableItem
import linc.com.weatherapp.R
import linc.com.weatherapp.databinding.ItemSavedLocationBinding
import linc.com.weatherapp.domain.entities.location.SavedLocationEntity
import linc.com.weatherapp.utils.AdapterClickListener

class SavedLocationItem(
    private val savedLocationEntity: SavedLocationEntity,
    private val clickListener: AdapterClickListener<SavedLocationEntity>
) : BindableItem<ItemSavedLocationBinding>() {

    override fun bind(viewBinding: ItemSavedLocationBinding, position: Int) {
        viewBinding.location = savedLocationEntity
        viewBinding.locationMoreActions.setOnClickListener {
            clickListener.onItemClick(savedLocationEntity)
        }
    }

    override fun getLayout() = R.layout.item_saved_location

    override fun initializeViewBinding(view: View) =
        ItemSavedLocationBinding.bind(view)
}