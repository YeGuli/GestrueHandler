package com.ye_guli.gesturelib;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

/**
 * Created by Ye_Guli on 2017/04/10.
 * <p>
 * 手势监听根类
 */
public abstract class AbsGestureListener extends SimpleOnGestureListener implements CustomGestureListener {
    @Override
    public boolean onZoomUpStart(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onZoomUpStop(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onZoomDownStart(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onZoomDownStop(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onMoveUpStart(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onMoveUpStop(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onMoveUpRightStart(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onMoveUpRightStop(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onMoveRightStart(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onMoveRightStop(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onMoveDownRightStart(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onMoveDownRightStop(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onMoveDownStart(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onMoveDownStop(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onMoveDownLeftStart(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onMoveDownLeftStop(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onMoveLeftStart(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onMoveLeftStop(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onMoveUpLeftStart(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onMoveUpLeftStop(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onActionStop(MotionEvent ev) {
        return false;
    }
}
