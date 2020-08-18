package com.hc.kotlinvideo.view

import com.hc.kotlinvideo.model.HomeBean
import com.hc.kotlinvideo.model.HomeItemBean

/**
 * Created by hcw  on 2020/8/18
 * 类描述：
 * all rights reserved
 */
interface HomeView {
    fun onError(message: String?)
    fun loadSuccess(list: List<HomeItemBean>?)
    fun loadMore(list: List<HomeItemBean>?)
}