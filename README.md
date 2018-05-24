[![](https://jitpack.io/v/YeGuli/GestrueHandler.svg)](https://jitpack.io/#YeGuli/GestrueHandler)
# GestrueHandler

## 介绍
封装一些云台控制常用手势操作监听的接口，当用户进行相应的手势操作时开发者可通过回调接口获取当前状态。

## 如何依赖
step 1:
在项目根目录下的build.gradle添加
```groove
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
step 2:
添加项目依赖
```groove
	dependencies {
	        implementation 'com.github.YeGuli:GestrueHandler:v1.0.0'
	}
```

## 如何使用

1. 需要创建一个手势监听类继承`AbsGestureListener`并在其中处理相应的手势操作：

   ```kotlin
   inner class MyGestureListener : AbsGestureListener() {
           override fun onZoomUpStart(ev: MotionEvent?): Boolean {
               return super.onZoomUpStart(ev)
           }

           override fun onZoomUpStop(ev: MotionEvent?): Boolean {
               return super.onZoomUpStop(ev)
           }

           override fun onZoomDownStart(ev: MotionEvent?): Boolean {
               return super.onZoomDownStart(ev)
           }

           override fun onZoomDownStop(ev: MotionEvent?): Boolean {
               return super.onZoomDownStop(ev)
           }

           override fun onMoveUpStart(ev: MotionEvent?): Boolean {
               return super.onMoveUpStart(ev)
           }

           override fun onMoveUpStop(ev: MotionEvent?): Boolean {
               return super.onMoveUpStop(ev)
           }

           override fun onMoveUpRightStart(ev: MotionEvent?): Boolean {
               return super.onMoveUpRightStart(ev)
           }

           override fun onMoveUpRightStop(ev: MotionEvent?): Boolean {
               return super.onMoveUpRightStop(ev)
           }

           override fun onMoveRightStart(ev: MotionEvent?): Boolean {
               return super.onMoveRightStart(ev)
           }

           override fun onMoveRightStop(ev: MotionEvent?): Boolean {
               return super.onMoveRightStop(ev)
           }

           override fun onMoveDownRightStart(ev: MotionEvent?): Boolean {
               return super.onMoveDownRightStart(ev)
           }

           override fun onMoveDownRightStop(ev: MotionEvent?): Boolean {
               return super.onMoveDownRightStop(ev)
           }

           override fun onMoveDownStart(ev: MotionEvent?): Boolean {
               return super.onMoveDownStart(ev)
           }

           override fun onMoveDownStop(ev: MotionEvent?): Boolean {
               return super.onMoveDownStop(ev)
           }

           override fun onMoveDownLeftStart(ev: MotionEvent?): Boolean {
               return super.onMoveDownLeftStart(ev)
           }

           override fun onMoveDownLeftStop(ev: MotionEvent?): Boolean {
               return super.onMoveDownLeftStop(ev)
           }

           override fun onMoveLeftStart(ev: MotionEvent?): Boolean {
               return super.onMoveLeftStart(ev)
           }

           override fun onMoveLeftStop(ev: MotionEvent?): Boolean {
               return super.onMoveLeftStop(ev)
           }

           override fun onMoveUpLeftStart(ev: MotionEvent?): Boolean {
               return super.onMoveUpLeftStart(ev)
           }

           override fun onMoveUpLeftStop(ev: MotionEvent?): Boolean {
               return super.onMoveUpLeftStop(ev)
           }
       }
   ```

2. 声明一个`GestureHandler`,其中`MyGestureListener`为上一步自定义的监听类：
	```kotlin
	private val handler: GestureHandler 
			            by lazy { GestureHandler(applicationContext,MyGestureListener()) }
	```
	
3. 在`Activity`或是需要监听手势操作的组件的`OnTouch`回调中使用`GestureHandler`处理：
	```kotlin
	override fun onTouchEvent(event: MotionEvent?): Boolean {
        handler.onDetectorGesture(event)
        return true
  }
	```
4. 具体实现效果可参考demo。