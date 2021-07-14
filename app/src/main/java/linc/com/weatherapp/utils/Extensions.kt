package linc.com.weatherapp.utils

import android.os.Build
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.hideStatusBar() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        window.insetsController?.hide(WindowInsets.Type.statusBars())
    } else {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }
}

fun <T> AutoCompleteTextView.updateOptions(options: List<T>) {
    ArrayAdapter<T>(this.context, android.R.layout.simple_list_item_1, options).also { adapter ->
        this.setAdapter(adapter)
    }
}