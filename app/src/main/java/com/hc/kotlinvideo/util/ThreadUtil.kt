package com.hc.kotlinvideo.util

import android.os.Handler
import android.os.Looper

/**
 * Created by hcw  on 2020/8/11
 * 类描述：
 * all rights reserved
 */
object ThreadUtil {

    val handler = Handler(Looper.getMainLooper())

    //运行到主线程
    fun runOnMainThread(runnable: Runnable){
        handler.post(runnable)
    }

}