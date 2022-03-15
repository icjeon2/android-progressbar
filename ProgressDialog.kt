package kr.co.hi.hiup.activity.web

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_web.*
import kotlinx.android.synthetic.main.progressbar.*
import kr.co.hi.hiup.R
import timber.log.Timber

class ProgressDialog(var activity: Activity) {
    private val inflater : LayoutInflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    private val frame = activity.frame_progress

    private lateinit var title : TextView
    private lateinit var progressbar : ProgressBar
    private lateinit var progressTxt : TextView
    private lateinit var percentage : TextView

    fun show(){
        inflater.inflate(R.layout.progressbar, frame, true)
        title = activity.tv_progressbarMessage
        progressbar = activity.progressBar
        progressTxt = activity.tv_progress
        percentage = activity.tv_percentage

        frame.visibility = View.VISIBLE
        activity.web_dim.visibility = View.VISIBLE
        activity.wv_main.apply {
            settings.apply {
                // 웹뷰클릭해도 반응x
                javaScriptEnabled = false
            }
        }
    }

    fun dismiss(){
        frame.visibility = View.INVISIBLE
        activity.web_dim.visibility = View.INVISIBLE
        activity.wv_main.apply {
            settings.apply {
                javaScriptEnabled = true
            }
        }
        frame.removeAllViews()
    }

    fun setTitle(msg : String) {
        title.text = msg
    }

    fun setMax(max: Int) {
        progressbar.max = max
        setTextViews()
    }

    private fun setTextViews() {
        progressTxt.text = "${progressbar.progress}/${progressbar.max}"
        if (progressbar.max != 0) {
            percentage.text = "${(
                    (progressbar.progress*100)
                        / progressbar.max
                    )}%"
        }
    }

    fun setProgress(progress : Int)
    {
        progressbar.progress = progress
        setTextViews()
    }
}
