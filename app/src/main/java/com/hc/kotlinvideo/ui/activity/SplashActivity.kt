package com.hc.kotlinvideo.ui.activity

import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.ViewPropertyAnimatorListener
import com.hc.kotlinvideo.R
import com.hc.kotlinvideo.base.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.startActivity

/**
 * Created by hcw  on 2020/8/4
 * 类描述：
 * all rights reserved
 */
class SplashActivity : BaseActivity() ,ViewPropertyAnimatorListener{
    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }


    override fun initData() {
        super.initData()
        //缩小动画，属性动画,直接通过 ViewCompat 就行
        //同时需要监听动画结束之后进入到主界面
        ViewCompat.animate(iv_splash_bg).scaleX(1.0f).scaleY(1.0f).setDuration(2000).setListener(this)

    }

    override fun onAnimationEnd(view: View?) {
        startActivityAndFinish<MainActivity>()
    }

    override fun onAnimationCancel(view: View?) {
    }

    override fun onAnimationStart(view: View?) {
    }

}