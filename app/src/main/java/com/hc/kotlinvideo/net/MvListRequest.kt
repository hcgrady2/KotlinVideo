package com.hc.kotlinvideo.net

import com.hc.kotlinvideo.model.MvPagerBean
import com.hc.kotlinvideo.net.MRequest
import com.hc.kotlinvideo.net.ResponseHandler
import com.hc.kotlinvideo.util.URLProviderUtils


/**
 * ClassName:MvListRequest
 * Description:mv每一个界面数据网络请求
 */
class MvListRequest(type: Int, code:String,offset:Int, handler: ResponseHandler<MvPagerBean>)
    : MRequest<MvPagerBean>(type, URLProviderUtils.getMVListUrl(code,offset,20), handler) {
}