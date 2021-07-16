package linc.com.weatherapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.util.Util
import kotlinx.android.synthetic.main.activity_main.*
import linc.com.weatherapp.R
import linc.com.weatherapp.databinding.ActivityMainBinding
import linc.com.weatherapp.utils.getResourceUri
import linc.com.weatherapp.utils.hideStatusBar

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private var player: SimpleExoPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideStatusBar()

        activityMainBinding = DataBindingUtil.setContentView(
            this@MainActivity,
            R.layout.activity_main
        )

        NavigationUI.setupWithNavController(
            activityMainBinding.bottomMenu,
            findNavController(R.id.nav_host_fragment)
        )
        activityMainBinding.bottomMenu.setOnNavigationItemReselectedListener {
            // Ignore reselected event
        }

    }

    // TODO: 15.07.21 move this functions to class like "BackgroundVideoPlayer"

    public override fun onStart() {
        super.onStart()
        if (Util.SDK_INT >= 24) {
            initializePlayer()
        }
    }

    public override fun onResume() {
        super.onResume()
        if ((Util.SDK_INT < 24 || player == null)) {
            initializePlayer()
        }
    }

    public override fun onPause() {
        super.onPause()
        if (Util.SDK_INT < 24) {
            releasePlayer()
        }
    }

    public override fun onStop() {
        super.onStop()
        if (Util.SDK_INT >= 24) {
            releasePlayer()
        }
    }

    private fun initializePlayer() {
        player = SimpleExoPlayer.Builder(this)
            .build()
            .also { exoPlayer ->
                activityMainBinding.videoView.player = exoPlayer
                val mediaItem = MediaItem.fromUri(getResourceUri(R.raw.cl2s_result))
                exoPlayer.setMediaItem(mediaItem)
            }
        player?.repeatMode = ExoPlayer.REPEAT_MODE_ALL
        player?.playWhenReady = true
        player?.prepare()
    }

    private fun releasePlayer() {
        player?.run {
            playWhenReady = this.playWhenReady
            release()
        }
        player = null
    }

}
