package linc.com.weatherapp.utils

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Bitmap
import android.media.MediaMetadataRetriever
import android.media.ThumbnailUtils
import android.net.Uri
import android.util.AttributeSet
import android.widget.VideoView
import androidx.annotation.RawRes
import linc.com.weatherapp.R


class IntroVideoView(context: Context, attrs: AttributeSet?, defStyleAttr: Int) :
    VideoView(context, attrs, defStyleAttr) {
    private val mScaleType: Int
    private var mHorizontalAspectRatioThreshold = 0
    private var mVerticalAspectRatioThreshold = 0
    private var currentUri: Uri? = null

    constructor(context: Context) : this(context, null, 0) {}
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0) {}

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        if (mScaleType == SCALE_TYPE_CENTER_CROP) {
            applyCenterCropMeasure(widthMeasureSpec, heightMeasureSpec)
        } else if (mScaleType == SCALE_TYPE_FILL) {
            applyFillMeasure(widthMeasureSpec, heightMeasureSpec)
        } // else default/no-op
    }

    override fun layout(l: Int, t: Int, r: Int, b: Int) {
        if (mScaleType == SCALE_TYPE_CENTER_CROP) {
            applyCenterCropLayout(l, t, r, b)
        } else {
            super.layout(l, t, r, b)
        }
    }

    fun pauseVideo() {
        pause()
    }

    fun startVideo() {
        start()
    }

    fun setVideoRaw(@RawRes resource: Int) {
        currentUri = Uri.parse("android.resource://${context.packageName}/$resource")
        setVideoURI(currentUri)
    }

    fun createVideoThumbnail(): Bitmap? {
        val mediametadataretriever = MediaMetadataRetriever()
        return try {
            if(currentUri == null)
                return null
            mediametadataretriever.setDataSource(context, currentUri)
            val bitmap = mediametadataretriever.getFrameAtTime(-1L)
            if (null != bitmap) {
                return ThumbnailUtils.extractThumbnail(bitmap, 200, 200, 2)
            }
            bitmap
        } catch (t: Throwable) {
            null
        } finally {
            try {
                mediametadataretriever.release()
            } catch (e: RuntimeException) {
            }
        }
    }

    private fun applyCenterCropLayout(left: Int, top: Int, right: Int, bottom: Int) {
        super.layout(
            left + mHorizontalAspectRatioThreshold, top + mVerticalAspectRatioThreshold,
            right
                    + mHorizontalAspectRatioThreshold, bottom + mVerticalAspectRatioThreshold
        )
    }

    private fun applyCenterCropMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val videoWidth = measuredWidth
        val videoHeight = measuredHeight
        val viewWidth = getDefaultSize(0, widthMeasureSpec)
        val viewHeight = getDefaultSize(0, heightMeasureSpec)
        mHorizontalAspectRatioThreshold = 0
        mVerticalAspectRatioThreshold = 0
        if (videoWidth == viewWidth) {
            val newWidth = (videoWidth.toFloat() / videoHeight * viewHeight).toInt()
            setMeasuredDimension(newWidth, viewHeight)
            mHorizontalAspectRatioThreshold = -(newWidth - viewWidth) / 2
        } else {
            val newHeight = (videoHeight.toFloat() / videoWidth * viewWidth).toInt()
            setMeasuredDimension(viewWidth, newHeight)
            mVerticalAspectRatioThreshold = -(newHeight - viewHeight) / 2
        }
    }

    private fun applyFillMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = getDefaultSize(0, widthMeasureSpec)
        val height = getDefaultSize(0, heightMeasureSpec)
        setMeasuredDimension(width, height)
    }

    companion object {
        private const val SCALE_TYPE_NORMAL = 0
        private const val SCALE_TYPE_CENTER_CROP = 1
        private const val SCALE_TYPE_FILL = 2
    }

    init {
        val attributes: TypedArray =
            context.getTheme().obtainStyledAttributes(attrs, R.styleable.IntroVideoView, 0, 0)
        mScaleType = attributes.getInt(R.styleable.IntroVideoView_scaleType, SCALE_TYPE_NORMAL)
    }
}