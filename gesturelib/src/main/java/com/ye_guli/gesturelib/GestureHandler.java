package com.ye_guli.gesturelib;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by Ye_Guli on 2017/04/10.
 * <p>
 * 手势监听判断方法
 */
public class GestureHandler {
    //是否多指触摸
    private boolean mIsMultiple = false;
    //是否单指触摸
    private boolean mIsSingle = false;

    //多指触摸下的两指距离
    private float mLastDistance;

    private GestureDetector mGestureDetector;
    private AbsGestureListener mGestureListener;
    private MotionEvent mCurrentDownEvent;

    private int gestureFlag = 0;
    private final int FLAG_MOVE_UP = 0x01;
    private final int FLAG_MOVE_UP_RIGHT = 0x02;
    private final int FLAG_MOVE_RIGHT = 0x03;
    private final int FLAG_MOVE_DOWN_RIGHT = 0x04;
    private final int FLAG_MOVE_DOWN = 0x05;
    private final int FLAG_MOVE_DOWN_LEFT = 0x06;
    private final int FLAG_MOVE_LEFT = 0x07;
    private final int FLAG_MOVE_UP_LEFT = 0x08;
    private final int FLAG_ZOOM_UP = 0x09;
    private final int FLAG_ZOOM_DOWN = 0x10;

    //点击位置与圆心在坐标轴上的投影的距离
    private float oX;
    private float oY;
    //点击位置与圆心的距离
    private float oR;
    //方向角
    private float oOrg;
    private float transverseOrg;
    private float longitudinalOrg;

    public GestureHandler(Context context, AbsGestureListener gestureListener) {
        if (context == null) {
            throw new IllegalArgumentException("context is null!");
        }
        if (gestureListener == null) {
            throw new IllegalArgumentException("mGestureListener is null!");
        }
        this.mGestureListener = gestureListener;
        mGestureDetector = new GestureDetector(context, mGestureListener);
    }

    //检测手势
    public boolean onDetectorGesture(MotionEvent ev) {
        if (ev == null) {
            return false;
        }
        final int action = MotionEventCompat.getActionMasked(ev);
        boolean isConsumed = false;

        switch (action) {//获得动作类型
            case MotionEvent.ACTION_DOWN:
                if (mCurrentDownEvent != null) {
                    mCurrentDownEvent.recycle();
                }
                mCurrentDownEvent = MotionEvent.obtain(ev);
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                if (gestureFlag == 0 && !mIsSingle) {
                    mIsMultiple = true;
                    mLastDistance = calculateDistance(ev);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (mIsMultiple && gestureFlag == 0) {
                    float distance = calculateDistance(ev);
                    if (distance - mLastDistance > 50f) {
                        mLastDistance = distance;
                        gestureFlag = FLAG_ZOOM_UP;
                        isConsumed = mGestureListener.onZoomUpStart(ev);
                    } else if (distance - mLastDistance < -50f) {
                        mLastDistance = distance;
                        gestureFlag = FLAG_ZOOM_DOWN;
                        isConsumed = mGestureListener.onZoomDownStart(ev);
                    }
                } else if (mIsSingle && gestureFlag == 0) {
                    isConsumed = calculateDirection(ev);
                } else if (!mIsMultiple && !mIsSingle && gestureFlag == 0) {
                    calculateDistance(mCurrentDownEvent, ev);
                }
                break;
            case MotionEvent.ACTION_UP:
                if (gestureFlag == FLAG_MOVE_UP) {
                    isConsumed = mGestureListener.onMoveUpStop(ev);
                } else if (gestureFlag == FLAG_MOVE_UP_RIGHT) {
                    isConsumed = mGestureListener.onMoveUpRightStop(ev);
                } else if (gestureFlag == FLAG_MOVE_RIGHT) {
                    isConsumed = mGestureListener.onMoveRightStop(ev);
                } else if (gestureFlag == FLAG_MOVE_DOWN_RIGHT) {
                    isConsumed = mGestureListener.onMoveDownRightStop(ev);
                } else if (gestureFlag == FLAG_MOVE_DOWN) {
                    isConsumed = mGestureListener.onMoveDownStop(ev);
                } else if (gestureFlag == FLAG_MOVE_DOWN_LEFT) {
                    isConsumed = mGestureListener.onMoveDownLeftStop(ev);
                } else if (gestureFlag == FLAG_MOVE_LEFT) {
                    isConsumed = mGestureListener.onMoveLeftStop(ev);
                } else if (gestureFlag == FLAG_MOVE_UP_LEFT) {
                    isConsumed = mGestureListener.onMoveUpLeftStop(ev);
                } else if (gestureFlag == FLAG_ZOOM_UP) {
                    isConsumed = mGestureListener.onZoomUpStop(ev);
                } else if (gestureFlag == FLAG_ZOOM_DOWN) {
                    isConsumed = mGestureListener.onZoomDownStop(ev);
                } else {
                    isConsumed = mGestureListener.onActionStop(ev);
                }
                gestureFlag = 0;
                mIsSingle = false;
                mIsMultiple = false;
                break;
        }
        return isConsumed || mGestureDetector.onTouchEvent(ev);
    }

    //计算单指移动的方向
    private boolean calculateDirection(MotionEvent e) {
        if (transverseOrg == 0 || longitudinalOrg == 0) {
            transverseOrg = (float) (Math.sin(22.5 * Math.PI / 180) / Math.cos(22.5 * Math.PI / 180));
            longitudinalOrg = (float) (Math.sin(67.5 * Math.PI / 180) / Math.cos(67.5 * Math.PI / 180));
        }
        oOrg = Math.abs(oY) / Math.abs(oX);
        if (oX > 0) {
            if (oY > 0) {
                if (oOrg < transverseOrg) {
                    gestureFlag = FLAG_MOVE_LEFT;
                    return mGestureListener.onMoveLeftStart(e);
                } else if (oOrg > longitudinalOrg) {
                    gestureFlag = FLAG_MOVE_UP;
                    return mGestureListener.onMoveUpStart(e);
                } else {
                    gestureFlag = FLAG_MOVE_UP_LEFT;
                    return mGestureListener.onMoveUpLeftStart(e);
                }
            } else {
                if (oOrg < transverseOrg) {
                    gestureFlag = FLAG_MOVE_LEFT;
                    return mGestureListener.onMoveLeftStart(e);
                } else if (oOrg > longitudinalOrg) {
                    gestureFlag = FLAG_MOVE_DOWN;
                    return mGestureListener.onMoveDownStart(e);
                } else {
                    gestureFlag = FLAG_MOVE_DOWN_LEFT;
                    return mGestureListener.onMoveDownLeftStart(e);
                }
            }
        } else {
            if (oY > 0) {
                if (oOrg < transverseOrg) {
                    gestureFlag = FLAG_MOVE_RIGHT;
                    return mGestureListener.onMoveRightStart(e);
                } else if (oOrg > longitudinalOrg) {
                    gestureFlag = FLAG_MOVE_UP;
                    return mGestureListener.onMoveUpStart(e);
                } else {
                    gestureFlag = FLAG_MOVE_UP_RIGHT;
                    return mGestureListener.onMoveUpRightStart(e);
                }
            } else {
                if (oOrg < transverseOrg) {
                    gestureFlag = FLAG_MOVE_RIGHT;
                    return mGestureListener.onMoveRightStart(e);
                } else if (oOrg > longitudinalOrg) {
                    gestureFlag = FLAG_MOVE_DOWN;
                    return mGestureListener.onMoveDownStart(e);
                } else {
                    gestureFlag = FLAG_MOVE_DOWN_RIGHT;
                    return mGestureListener.onMoveDownRightStart(e);
                }
            }
        }
    }

    //计算单点触摸下移动的距离
    private void calculateDistance(MotionEvent e1, MotionEvent e2) {
        oX = e1.getX() - e2.getX();
        oY = e1.getY() - e2.getY();
        oR = (float) Math.sqrt(oX * oX + oY * oY);
        if (oR > 50f) {
            mIsSingle = true;
        }
    }

    //计算多点触摸下两指的距离
    private float calculateDistance(MotionEvent event) {
        if (event.getPointerCount() >= 2) {
            float diffX = event.getX(0) - event.getX(1);
            float diffY = event.getY(0) - event.getY(1);
            return (float) Math.sqrt(diffX * diffX + diffY * diffY);
        }
        return 0f;
    }
}
