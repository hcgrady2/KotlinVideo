package com.hc.kotlinvideo.base

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hc.kotlinvideo.ui.activity.MainActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.startActivity
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


    //加上 Open 关键字子类才能复写
    open protected fun initData() {
        //TODO("Not yet implemented")
    }

    open protected fun initListener() {
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

    //跳转到对应 Activity 并结束当前类
    inline fun <reified T: BaseActivity>startActivityAndFinish(){
        startActivity<T>()
        finish()
    }

}