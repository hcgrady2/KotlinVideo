package com.hc.kotlinvideo.net

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hc.kotlinvideo.model.HomeBean
import okhttp3.Response
import java.lang.reflect.ParameterizedType

/**
 * Created by hcw  on 2020/8/19
 * 类描述：
 * all rights reserved
 */

//加上 Open 才能被继承
open class MRequest<RESPONSE>(val url:String,val handler:ResponseHandler<RESPONSE>) {
    //解析网络请求结果
    fun pareseResult(result: String): RESPONSE {
        val gson = Gson()
        //获取泛型类型
        val type = (this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]

        val list = gson.fromJson<RESPONSE>(
            result,type
        )

        return  list

    }


}