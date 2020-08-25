package com.hc.kotlinvideo.ui.fragment

import android.os.Build
import android.util.Log
import android.view.View
import android.webkit.WebSettings
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hc.kotlinvideo.R
import com.hc.kotlinvideo.adapter.HomeAdapter
import com.hc.kotlinvideo.base.BaseFragment
import com.hc.kotlinvideo.model.HomeBean
import com.hc.kotlinvideo.model.HomeItemBean
import com.hc.kotlinvideo.presenter.impl.HomePresenterImpl
import com.hc.kotlinvideo.util.ThreadUtil
import com.hc.kotlinvideo.util.URLProviderUtils
import com.hc.kotlinvideo.view.HomeView
import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.*
import java.io.IOException

/**
 * Created by hcw  on 2020/8/10
 * 类描述：
 * all rights reserved
 */
class HomeFragment : BaseFragment(),HomeView {
    override fun initView(): View? {
        return  View.inflate(context,R.layout.fragment_home,null)
    }

    //条目适配
    val adapter by lazy {
        //条目适配
        HomeAdapter()
    }


    val presenter  by lazy {
        HomePresenterImpl(this)
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun initListener() {
        super.initListener()
        recycler_view.layoutManager = LinearLayoutManager(context)
        //条目适配
       // val adapter = HomeAdapter()
        recycler_view.adapter = adapter
        //下拉刷新控件初始化
        refresh_layout.setColorSchemeColors(resources.getColor(R.color.colorAccent),
            resources.getColor(R.color.colorPrimary),resources.getColor(R.color.green))


        //下拉刷新监听
        refresh_layout.setOnRefreshListener {
            presenter.loadDatas(context)
        }
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun initData() {
        super.initData()
        presenter.loadDatas(context)
        //SpringBootApi()

        //监听滑动
        recycler_view.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

//                when(newState){
//                    RecyclerView.SCROLL_STATE_IDLE->{
//                        println("idel")
//                    }
//
//                    RecyclerView.SCROLL_STATE_DRAGGING->{
//                        println("drag")
//                    }
//
//                    RecyclerView.SCROLL_STATE_SETTLING->{
//                        println("SETTING")
//                    }
//
//                }

                //通过 idle 即可判断是否滑动到最后一条
                if(newState == RecyclerView.SCROLL_STATE_IDLE){
                    //是否是最后一条
                    val layoutManager = recyclerView.layoutManager
                    if (layoutManager is LinearLayoutManager){
                        val manager :LinearLayoutManager = layoutManager
                        val lastPosition  = manager.findLastVisibleItemPosition()
                        if (lastPosition == adapter.itemCount - 1 ){
                                presenter.loadDataMore(lastPosition,context)
                        }


                    }
                }

            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

              //  println("scrolled")

            }
        })
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private fun loadDataMore(offset:Int) {
        //see presenter
    }



    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private fun loadDatas() {
        //set loadData
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

    override fun onError(message: String?) {
        refresh_layout.isRefreshing = false
        myToast("加载数据失败" )
    }

    override fun loadSuccess(list: List<HomeItemBean>?) {
        refresh_layout.isRefreshing = false
        //刷新列表
        adapter.setData(list)
    }

    override fun loadMore(list: List<HomeItemBean>?) {
        refresh_layout.isRefreshing = false
        adapter.loadMore(list)
    }

}