package com.hc.kotlinvideo.presenter.impl

import android.content.Context
import android.os.Build
import android.util.Log
import android.webkit.WebSettings
import androidx.annotation.RequiresApi
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hc.kotlinvideo.model.HomeBean
import com.hc.kotlinvideo.model.HomeItemBean
import com.hc.kotlinvideo.net.HomeRequset
import com.hc.kotlinvideo.net.NetManager
import com.hc.kotlinvideo.net.ResponseHandler
import com.hc.kotlinvideo.presenter.`interface`.HomePresenter
import com.hc.kotlinvideo.util.ThreadUtil
import com.hc.kotlinvideo.util.URLProviderUtils
import com.hc.kotlinvideo.view.HomeView
import com.hc.kotlinvideo.widget.HomeItemView
import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.*
import java.io.IOException

/**
 * Created by hcw  on 2020/8/18
 * 类描述：
 * all rights reserved
 */
//加上 VAR 其他够在函数才能使用
class HomePresenterImpl(var homeView :HomeView?) : HomePresenter,ResponseHandler<List<HomeItemBean>> {


    init {
        homeView
    }


    //解绑
    fun  destroyView(){
         if(homeView != null){
             homeView = null
         }
    }







    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun loadDatas(context:Context?) {

//        val requset = HomeRequset(0,object :ResponseHandler<List<HomeItemBean>>{
//            override fun onError(msg: String?) {
//                //NetManager 已经处理线程了
//                homeView.onError(msg)
//            }
//
//            override fun onSuccess(result: List<HomeItemBean>) {
//                homeView.loadSuccess(result)
//            }
//        }).execute()
//      //  NetManager.manager.sendRequest(requset)



        val requset = HomeRequset(HomePresenter.TYPE_INIT_OR_REFRESH,0,this).execute()
        //  NetManager.manager.sendRequest(requset)





//        val path  = URLProviderUtils.getHomeUrl(0,20)
//        val client = OkHttpClient()
//        val requeset = Request.Builder()
//            .url(path)
//            .removeHeader("User-Agent")
//            .addHeader("User-Agent", WebSettings.getDefaultUserAgent(context))
//            .get()
//            .build()
//
//        client.newCall(requeset).enqueue(object :Callback{
//            /**
//             * 注意两个回调都是自线程的
//             */
//            override fun onFailure(call: Call, e: IOException) {
//                ThreadUtil.runOnMainThread(object :Runnable{
//                    override fun run() {
//                       // refresh_layout.isRefreshing = false
//                        //p 层处理完数据回调给 VIEW
//                        homeView.onError(e?.message)
//                    }
//                })
//                Log.i("hctag", "onFailure: 获取数据出错:" + e)
//            //    myToast("获取数据出错")
//
//            }
//
//            override fun onResponse(call: Call, response: Response) {
//                // myToast("获取数据成功")
//                val result = response.body?.string().toString()
//                val gson = Gson()
//                //object 匿名内部类
//                // val list = gson.fromJson<List<HomeItemBean>>(result,object :TypeToken<List<HomeItemBean>>(){}.type)
//                val list = gson.fromJson<HomeBean>(
//                    result,
//                    object : TypeToken<HomeBean>() {}.type
//                )
//
//                // val list = gson.fromJson<List<HomeItemBean>>(result,object :TypeToken<List<HomeItemBean>>() {}.type)
//
//                //主线程刷新列表
////                ThreadUtil.runOnMainThread(object :Runnable{
////                    override fun run() {
////                        adapter.updateList(list)
////                    }
////                })
//
//                ThreadUtil.runOnMainThread(object : Runnable {
//                    override fun run() {
//                        Log.i("hctag", "run: 准备隐藏 REFRESH")
//                        //refresh_layout.isRefreshing = false
//                       // adapter.setData(list.songlist)
//
//
//                        homeView.loadSuccess(list.songlist)
//
//                    }
//                });
//            }
//
//        })
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun loadDataMore(lastPosition: Int, context: Context?) {

        //3.0
        val requset = HomeRequset(HomePresenter.TYPE_INIT_OR_LOADMORE,lastPosition,this).execute()

  //      NetManager.manager.sendRequest(requset)


//        val path  = URLProviderUtils.getHomeUrl(lastPosition,20)
//        val client = OkHttpClient()
//        val requeset = Request.Builder()
//            .url(path)
//            .removeHeader("User-Agent")
//            .addHeader("User-Agent", WebSettings.getDefaultUserAgent(context))
//            .get()
//            .build()
//
//        client.newCall(requeset).enqueue(object : Callback {
//            /**
//             * 注意两个回调都是自线程的
//             */
//            override fun onFailure(call: Call, e: IOException) {
//                ThreadUtil.runOnMainThread(object :Runnable{
//
//                    override fun run() {
//                       // refresh_layout.isRefreshing = false
//                        homeView.onError(e?.message)
//                    }
//                })
//                Log.i("hctag", "onFailure: 获取数据出错:" + e)
//               //myToast("获取数据出错")
//
//            }
//
//            override fun onResponse(call: Call, response: Response) {
//                // myToast("获取数据成功")
//                val result = response.body?.string().toString()
//                val gson = Gson()
//                //object 匿名内部类
//                // val list = gson.fromJson<List<HomeItemBean>>(result,object :TypeToken<List<HomeItemBean>>(){}.type)
//                val list = gson.fromJson<HomeBean>(
//                    result,
//                    object : TypeToken<HomeBean>() {}.type
//                )
//
//                // val list = gson.fromJson<List<HomeItemBean>>(result,object :TypeToken<List<HomeItemBean>>() {}.type)
//
//                //主线程刷新列表
////                ThreadUtil.runOnMainThread(object :Runnable{
////                    override fun run() {
////                        adapter.updateList(list)
////                    }
////                })
//
//                ThreadUtil.runOnMainThread(object : Runnable {
//                    override fun run() {
//                        Log.i("hctag", "run: 准备隐藏 REFRESH")
//                       // refresh_layout.isRefreshing = false
//                        //adapter.loadMore(list.songlist)
//                        homeView.loadMore(list.songlist)
//                    }
//                });
//            }
//
//        })
//
//

    }

    //统一封装数据回掉
    override fun onError(type:Int,msg: String?) {
        homeView?.onError(msg)
    }

    //需要区分是初始化还是加载更多
    override fun onSuccess(type:Int,result: List<HomeItemBean>) {

        when(type){
           HomePresenter. TYPE_INIT_OR_REFRESH-> homeView?.loadSuccess(result)
           HomePresenter. TYPE_INIT_OR_LOADMORE-> homeView?.loadMore(result)
        }




    }

}