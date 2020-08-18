package com.hc.kotlinvideo.presenter.`interface`

import android.content.Context

/**
 * Created by hcw  on 2020/8/18
 * 类描述：
 * all rights reserved
 */
interface HomePresenter {
    fun loadDatas(context:Context?)
    fun loadDataMore(lastPosition: Int,context: Context?)
}