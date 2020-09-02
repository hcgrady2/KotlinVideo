package com.hc.kotlinvideo.view

import com.hc.kotlinvideo.model.MvAreaBean


/**
 * ClassName:MvView
 * Description:
 */
interface MvView {
    fun  onError(msg: String?)
    fun  onSuccess(result: List<MvAreaBean>)
}