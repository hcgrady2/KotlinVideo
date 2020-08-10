package com.hc.kotlinvideo.ui.fragment

import android.view.Gravity
import android.view.View
import android.widget.TextView
import com.hc.kotlinvideo.base.BaseFragment

/**
 * Created by hcw  on 2020/8/10
 * 类描述：
 * all rights reserved
 */
class YueDanFragment : BaseFragment() {
    override fun initView(): View? {

        val  tv = TextView(context)
        tv.gravity = Gravity.CENTER
        tv.text = javaClass.simpleName
        return  tv
    }
}