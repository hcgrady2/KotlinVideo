package com.hc.kotlinvideo.net

import com.hc.kotlinvideo.model.YueDanBean
import com.hc.kotlinvideo.util.URLProviderUtils

/**
 * Created by hcw  on 2020/8/26
 * 类描述：悦单网络请求
 * all rights reserved
 */
class YueDanRequest (type:Int,offset:Int,handler: ResponseHandler<YueDanBean>)
    : MRequest<YueDanBean>(type,URLProviderUtils.getYueDanUrl(offset,20),handler) {


}