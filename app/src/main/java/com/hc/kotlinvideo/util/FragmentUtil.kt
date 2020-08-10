package com.hc.kotlinvideo.util

import com.hc.kotlinvideo.R
import com.hc.kotlinvideo.base.BaseFragment
import com.hc.kotlinvideo.ui.fragment.HomeFragment
import com.hc.kotlinvideo.ui.fragment.MvFragment
import com.hc.kotlinvideo.ui.fragment.VBangFragment
import com.hc.kotlinvideo.ui.fragment.YueDanFragment

/**
 * Created by hcw  on 2020/8/10
 * 类描述： 管理 Fragment，单例
 * all rights reserved
 */

//单例需要私有化构造方法
class FragmentUtil  private constructor(){

    val homeFragment by lazy { HomeFragment() }
    val mvFragment by lazy { MvFragment() }
    val vbangFragment by lazy { VBangFragment() }
    val yuedanFragment by lazy { YueDanFragment() }


    //通过伴生对象来提供静态方法获取类应用
    companion object{
        //by lazy 惰性且线程安全
        val fragmentUtil by lazy { FragmentUtil() }
    }


    //根据 id 获取 Fragment
    fun getFragment(tabId:Int) :BaseFragment?{
        when(tabId){
            R.id.tab_home ->  return  homeFragment
            R.id.tab_mv ->  return  mvFragment
            R.id.tab_vbang ->  return  vbangFragment
            R.id.tab_yuedan ->  return  yuedanFragment
        }
        return null
    }
}