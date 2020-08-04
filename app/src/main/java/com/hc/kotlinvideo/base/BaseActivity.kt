package com.hc.kotlinvideo.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.toast

/**
 * Created by hcw  on 2020/8/4
 * 类描述：所有 Activity 的基类
 * all rights reserved
 */
//继承 AnkoLogger 实现打印功能
abstract class BaseActivity :AppCompatActivity(),AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())

        //adapter 等初始化
        initListener()
        initData()
    }


    protected fun initData() {
        //TODO("Not yet implemented")
    }

    protected fun initListener() {
        //TODO("Not yet implemented")
    }

    abstract  fun getLayoutId():Int


    //统一 toast,处理线程问题
    protected  fun myToast(msg:String){
        runOnUiThread {
            toast(msg)
        }
    }

    //log 打印(通过 Anko )



}