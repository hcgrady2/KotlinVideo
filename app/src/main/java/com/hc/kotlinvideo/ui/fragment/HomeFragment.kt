package com.hc.kotlinvideo.ui.fragment

import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hc.kotlinvideo.R
import com.hc.kotlinvideo.adapter.HomeAdapter
import com.hc.kotlinvideo.base.BaseFragment
import com.hc.kotlinvideo.model.HomeItemBean
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

    override fun initData() {
        super.initData()
        loadDatas();
    }

    private fun loadDatas() {
        val path  = URLProviderUtils.getHomeUrl(0,20)
        val client = OkHttpClient()
        val requeset = Request.Builder()
            .url(path)
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
                Log.i("hctag", "onFailure: 获取数据成功:" + Thread.currentThread().name)

                myToast("获取数据成功")

                val result = response?.body?.toString()
                val gson = Gson()
                //object 匿名内部类
                val list = gson.fromJson<List<HomeItemBean>>(result,object :TypeToken<List<HomeItemBean>>(){}.type)
                //主线程刷新列表

                ThreadUtil.runOnMainThread(object :Runnable{
                    override fun run() {
                        adapter.updateList(list)
                    }
                })
            }

        })
    }

}