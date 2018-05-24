package com.ye_guli.gesturelib;

import android.view.MotionEvent;

/**
 * Created by Ye_Guli on 2017/04/10.
 * <p>
 * 手势监听根类
 */
public interface CustomGestureListener {
    public abstract boolean onZoomUpStart(MotionEvent ev);

    public abstract boolean onZoomUpStop(MotionEvent ev);

    public abstract boolean onZoomDownStart(MotionEvent ev);

    public abstract boolean onZoomDownStop(MotionEvent ev);

    public abstract boolean onMoveUpStart(MotionEvent ev);

    public abstract boolean onMoveUpStop(MotionEvent ev);

    public abstract boolean onMoveUpRightStart(MotionEvent ev);

    public abstract boolean onMoveUpRightStop(MotionEvent ev);

    public abstract boolean onMoveRightStart(MotionEvent ev);

    public abstract boolean onMoveRightStop(MotionEvent ev);

    public abstract boolean onMoveDownRightStart(MotionEvent ev);

    public abstract boolean onMoveDownRightStop(MotionEvent ev);

    public abstract boolean onMoveDownStart(MotionEvent ev);

    public abstract boolean onMoveDownStop(MotionEvent ev);

    public abstract boolean onMoveDownLeftStart(MotionEvent ev);

    public abstract boolean onMoveDownLeftStop(MotionEvent ev);

    public abstract boolean onMoveLeftStart(MotionEvent ev);

    public abstract boolean onMoveLeftStop(MotionEvent ev);

    public abstract boolean onMoveUpLeftStart(MotionEvent ev);

    public abstract boolean onMoveUpLeftStop(MotionEvent ev);

    public abstract boolean onActionStop(MotionEvent ev);
}
