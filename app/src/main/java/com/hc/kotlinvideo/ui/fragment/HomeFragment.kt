package com.hc.kotlinvideo.ui.fragment

import android.os.Build
import android.util.Log
import android.view.View
import android.webkit.WebSettings
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hc.kotlinvideo.R
import com.hc.kotlinvideo.adapter.HomeAdapter
import com.hc.kotlinvideo.base.BaseFragment
import com.hc.kotlinvideo.model.HomeBean
import com.hc.kotlinvideo.util.ThreadUtil
import com.hc.kotlinvideo.util.URLProviderUtils
import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.*
import java.io.IOException

/**
 * Created by hcw  on 2020/8/10
 * 类描述：
 * all rights reserved
 */
class HomeFragment : BaseFragment() {
    override fun initView(): View? {
        return  View.inflate(context,R.layout.fragment_home,null)
    }

    //条目适配
    val adapter by lazy {
        //条目适配
        HomeAdapter()
    }

    override fun initListener() {
        super.initListener()
        recycler_view.layoutManager = LinearLayoutManager(context)
        //条目适配
       // val adapter = HomeAdapter()
        recycler_view.adapter = adapter

    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun initData() {
        super.initData()
        loadDatas();
        //SpringBootApi()
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private fun loadDatas() {
        val path  = URLProviderUtils.getHomeUrl(0,20)
        val client = OkHttpClient()
        val requeset = Request.Builder()
            .url(path)
            .removeHeader("User-Agent")
            .addHeader("User-Agent", WebSettings.getDefaultUserAgent(context))
            .get()
            .build()

        client.newCall(requeset).enqueue(object :Callback{
            /**
             * 注意两个回调都是自线程的
             */
            override fun onFailure(call: Call, e: IOException) {
                Log.i("hctag", "onFailure: 获取数据出错:" + Thread.currentThread().name)
                myToast("获取数据出错")
            }

            override fun onResponse(call: Call, response: Response) {

               // myToast("获取数据成功")
                val result = response.body?.string().toString()
                val gson = Gson()
                //object 匿名内部类
               // val list = gson.fromJson<List<HomeItemBean>>(result,object :TypeToken<List<HomeItemBean>>(){}.type)
                val list = gson.fromJson<HomeBean>(
                    result,
                    object : TypeToken<HomeBean>() {}.type
                )
             // val list = gson.fromJson<List<HomeItemBean>>(result,object :TypeToken<List<HomeItemBean>>() {}.type)

                //主线程刷新列表
//                ThreadUtil.runOnMainThread(object :Runnable{
//                    override fun run() {
//                        adapter.updateList(list)
//                    }
//                })


                ThreadUtil.runOnMainThread(object : Runnable {
                    override fun run() {
                        adapter.setData(list.songlist)
                    }
                });
            }

        })
    }


    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private fun SpringBootApi(){
        val client = OkHttpClient()
        val requeset = Request.Builder()
            .url("http://192.168.31.168:8999/hc/doGet")
            .removeHeader("User-Agent")
            .addHeader("User-Agent", WebSettings.getDefaultUserAgent(context))
            .get()
            .build()

        client.newCall(requeset).enqueue(object :Callback{
            override fun onFailure(call: Call, e: IOException) {
                Log.i("hctag", "onFailure: 获取数据出错:" + Thread.currentThread().name)
            }

            override fun onResponse(call: Call, response: Response) {
                val i = Log.i("hctag", "onResponse: 获取数据成功:" + response.body?.string().toString())

            }

        })
    }

}