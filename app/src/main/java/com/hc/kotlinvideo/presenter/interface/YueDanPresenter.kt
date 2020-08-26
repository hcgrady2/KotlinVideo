package com.hc.kotlinvideo.presenter.`interface`

import android.content.Context

/**
 * Created by hcw  on 2020/8/26
 * 类描述：
 * all rights reserved
 */
interface YueDanPresenter {

    companion object{
        val TYPE_INIT_OR_REFRESH   =1
        val TYPE_INIT_OR_LOADMORE   =2
    }

    fun loadDatas(context: Context?)
    fun loadDataMore(lastPosition: Int,context: Context?)



}