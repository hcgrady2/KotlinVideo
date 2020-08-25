package com.hc.kotlinvideo.net

import android.util.Log
import android.webkit.WebSettings
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hc.kotlinvideo.model.HomeBean
import com.hc.kotlinvideo.presenter.`interface`.HomePresenter
import com.hc.kotlinvideo.util.ThreadUtil
import com.hc.kotlinvideo.util.URLProviderUtils
import okhttp3.*
import java.io.IOException

/**
 * Created by hcw  on 2020/8/19
 * 类描述：
 * all rights reserved
 */
class NetManager private  constructor(){

    val client by lazy {
        OkHttpClient()
    }

    companion object{
        val manager by lazy {
            NetManager()
        }
    }

    //发送网络请求
    fun <RESPONSE>sendRequest(req:MRequest<RESPONSE>){
        //url 在 req 中
        //val path  = URLProviderUtils.getHomeUrl(lastPosition,20)

        val requeset = Request.Builder()
            .url(req.url)
            .removeHeader("User-Agent")
          //  .addHeader("User-Agent", WebSettings.getDefaultUserAgent(context))
            .addHeader("User-Agent", "Mozillo/5.0")
            .get()
            .build()

        client.newCall(requeset).enqueue(object : Callback {
            /**
             * 注意两个回调都是自线程的
             */
            override fun onFailure(call: Call, e: IOException) {
                ThreadUtil.runOnMainThread(object :Runnable{

                    override fun run() {
                        //1.0
                        // refresh_layout.isRefreshing = false
                        //2.0
                        //homeView.onError(e?.message)
                        //3.0
                        req.handler.onError(req.type,e?.message)
                    }
                })
                Log.i("hctag", "onFailure: 获取数据出错:" + e)
                //myToast("获取数据出错")

            }

            override fun onResponse(call: Call, response: Response) {
                Log.i("hcTag", "onResponse: 获取数据成功:" + response.body?.string())
                // myToast("获取数据成功")




             //   val gson = Gson()
                //object 匿名内部类
                // val list = gson.fromJson<List<HomeItemBean>>(result,object :TypeToken<List<HomeItemBean>>(){}.type)



//                val gson = Gson()
//                val list = gson.fromJson<HomeBean>(
//                    result,
//                    object : TypeToken<HomeBean>() {}.type
//                )




                if (response.isSuccessful && response.code == 200){


                    val result = response.body?.string().toString()


                    //NetManager 不知道每个页面要解析成的具体对象
                    val parseResult = req.pareseResult(result)


                    ThreadUtil.runOnMainThread(object : Runnable {
                        override fun run() {
                            Log.i("hctag", "run: 准备隐藏 REFRESH")
                            // refresh_layout.isRefreshing = false
                            //adapter.loadMore(list.songlist)
                            //2.0
                            // homeView.loadMore(list.songlist)

                            //3.0
                            req.handler.onSuccess(req.type,parseResult)

                        }
                    })


                }else{
                    Log.i("hcTag", "onResponse: 服务器错误")
                    req.handler.onError(HomePresenter.TYPE_INIT_OR_LOADMORE,"server error")
                }





                // val list = gson.fromJson<List<HomeItemBean>>(result,object :TypeToken<List<HomeItemBean>>() {}.type)

                //主线程刷新列表
//                ThreadUtil.runOnMainThread(object :Runnable{
//                    override fun run() {
//                        adapter.updateList(list)
//                    }
//                })




            }

        })
    }
}