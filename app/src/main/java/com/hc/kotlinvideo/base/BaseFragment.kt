package com.hc.kotlinvideo.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug
import org.jetbrains.anko.support.v4.runOnUiThread
import org.jetbrains.anko.support.v4.toast

/**
 * Created by hcw  on 2020/8/4
 * 类描述：所有 Fragment 基类
 * all rights reserved
 */
abstract  class BaseFragment : Fragment(),AnkoLogger{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        debug("这是 Anko 打印的");
    }

    //fragment 初始化
    open protected fun init() {

    }

    open protected fun initData() {
    }

    open protected fun initListener() {
    }

    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return initView()
    }

    //获取布局 View
    abstract fun initView(): View?

    //Activity 创建完成之后
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //数据初始化
        initListener()
        initData()
    }

    fun myToast(msg:String){
        runOnUiThread {
            toast(msg)
        }
    }


}