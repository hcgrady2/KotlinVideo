package com.hc.kotlinvideo.net

import com.hc.kotlinvideo.model.MvAreaBean
import com.hc.kotlinvideo.util.URLProviderUtils


/**
 * ClassName:MvAreaRequest
 * Description:mv区域数据请求
 */
class MvAreaRequest(handler: ResponseHandler<List<MvAreaBean>>)
    : MRequest<List<MvAreaBean>>(0, URLProviderUtils.getMVareaUrl(), handler) {
}