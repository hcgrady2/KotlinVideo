package com.hc.kotlinvideo.view

import com.hc.kotlinvideo.model.HomeItemBean
import com.hc.kotlinvideo.model.YueDanBean

/**
 * Created by hcw  on 2020/8/26
 * 类描述：
 * all rights reserved
 */
interface YueDanView{

    fun onError(message: String?)
    fun loadSuccess(response: YueDanBean?)
    fun loadMore(response: YueDanBean?)



}