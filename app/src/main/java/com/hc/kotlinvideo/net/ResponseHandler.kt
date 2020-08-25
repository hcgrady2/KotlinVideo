package com.hc.kotlinvideo.net

/**
 * Created by hcw  on 2020/8/19
 * 类描述：
 * all rights reserved
 */
interface ResponseHandler<RESPONSER> {

    fun onError(type:Int ,msg:String?)

    fun onSuccess(type:Int,result:RESPONSER)

}