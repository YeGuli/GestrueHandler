package com.ye_guli.gesturehandler

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MotionEvent
import com.ye_guli.gesturelib.AbsGestureListener
import com.ye_guli.gesturelib.GestureHandler
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val handler: GestureHandler by lazy { GestureHandler(applicationContext, MyGestureListener()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        handler.onDetectorGesture(event)
        return true
    }

    @SuppressLint("SetTextI18n")
    inner class MyGestureListener : AbsGestureListener() {
        override fun onZoomUpStart(ev: MotionEvent?): Boolean {
            tv?.text = "onZoomUpStart"
            return true
        }

        override fun onZoomUpStop(ev: MotionEvent?): Boolean {
            tv?.text = "onZoomUpStop"
            return true
        }

        override fun onZoomDownStart(ev: MotionEvent?): Boolean {
            tv?.text = "onZoomDownStart"
            return true
        }

        override fun onZoomDownStop(ev: MotionEvent?): Boolean {
            tv?.text = "onZoomDownStop"
            return true
        }

        override fun onMoveUpStart(ev: MotionEvent?): Boolean {
            tv?.text = "onMoveUpStart"
            return true
        }

        override fun onMoveUpStop(ev: MotionEvent?): Boolean {
            tv?.text = "onMoveUpStop"
            return true
        }

        override fun onMoveUpRightStart(ev: MotionEvent?): Boolean {
            tv?.text = "onMoveUpRightStart"
            return true
        }

        override fun onMoveUpRightStop(ev: MotionEvent?): Boolean {
            tv?.text = "onMoveUpRightStop"
            return true
        }

        override fun onMoveRightStart(ev: MotionEvent?): Boolean {
            tv?.text = "onMoveRightStart"
            return true
        }

        override fun onMoveRightStop(ev: MotionEvent?): Boolean {
            tv?.text = "onMoveRightStop"
            return true
        }

        override fun onMoveDownRightStart(ev: MotionEvent?): Boolean {
            tv?.text = "onMoveDownRightStart"
            return true
        }

        override fun onMoveDownRightStop(ev: MotionEvent?): Boolean {
            tv?.text = "onMoveDownRightStop"
            return true
        }

        override fun onMoveDownStart(ev: MotionEvent?): Boolean {
            tv?.text = "onMoveDownStart"
            return true
        }

        override fun onMoveDownStop(ev: MotionEvent?): Boolean {
            tv?.text = "onMoveDownStop"
            return true
        }

        override fun onMoveDownLeftStart(ev: MotionEvent?): Boolean {
            tv?.text = "onMoveDownLeftStart"
            return true
        }

        override fun onMoveDownLeftStop(ev: MotionEvent?): Boolean {
            tv?.text = "onMoveDownLeftStop"
            return true
        }

        override fun onMoveLeftStart(ev: MotionEvent?): Boolean {
            tv?.text = "onMoveLeftStart"
            return true
        }

        override fun onMoveLeftStop(ev: MotionEvent?): Boolean {
            tv?.text = "onMoveLeftStop"
            return true
        }

        override fun onMoveUpLeftStart(ev: MotionEvent?): Boolean {
            tv?.text = "onMoveUpLeftStart"
            return true
        }

        override fun onMoveUpLeftStop(ev: MotionEvent?): Boolean {
            tv?.text = "onMoveUpLeftStop"
            return true
        }
    }
}
