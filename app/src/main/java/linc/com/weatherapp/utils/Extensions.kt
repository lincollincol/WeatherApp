package linc.com.weatherapp.utils

import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView

fun <T> AutoCompleteTextView.updateOptions(options: List<T>) {
    ArrayAdapter<T>(this.context, android.R.layout.simple_list_item_1, options).also { adapter ->
        this.setAdapter(adapter)
    }
}