package com.hc.kotlinvideo.net

import com.hc.kotlinvideo.model.HomeItemBean
import com.hc.kotlinvideo.util.URLProviderUtils

/**
 * Created by hcw  on 2020/8/19
 * 类描述：
 * all rights reserved
 */
class HomeRequset(type:Int,offset:Int,handler: ResponseHandler<List<HomeItemBean>>)
    : MRequest<List<HomeItemBean>>(type,URLProviderUtils.getHomeUrl2(offset,20),handler) {
}