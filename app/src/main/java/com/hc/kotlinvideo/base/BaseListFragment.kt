package com.hc.kotlinvideo.base

import android.graphics.Color
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import com.hc.kotlinvideo.R
import kotlinx.android.synthetic.main.fragment_list.*


/**
 * ClassName:BaseListFragment
 * Description:所有具有下拉刷新和上拉加载更多列表界面的基类
 * 基类抽取
 * HomeView->BaseView
 * Presenter->BaseListPresenter
 * Adapter->BaseListAdapter
 */
abstract class BaseListFragment<RESPONSE,ITEMBEAN,ITEMVIEW:View> : BaseFragment(), BaseView<RESPONSE> {
    override fun onError(message: String?) {
        myToast("加载数据失败")
    }

    override fun loadSuccess(response:RESPONSE?) {
        //隐藏刷新控件
        refresh_layout.isRefreshing = false
        //刷新列表
        adapter.updateList(getList(response))
    }



    override fun loadMore(response: RESPONSE?) {
        adapter.loadMore(getList(response))
    }

    //适配
    val adapter by lazy { getSpecialAdapter() }
//    getAdapter()

    val presenter by lazy { getSpecialPresenter() }



    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_list, null)
    }

    override fun initListener() {
        //初始化recycleview
        recycler_view.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)

        recycler_view.adapter = adapter

        //初始化刷新控件
        refresh_layout.setColorSchemeColors(Color.RED, Color.YELLOW, Color.GREEN)
        //刷新监听
        refresh_layout.setOnRefreshListener {
            //刷新监听
            presenter.loadDatas()
        }
        //监听列表滑动
        recycler_view.addOnScrollListener(object : androidx.recyclerview.widget.RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: androidx.recyclerview.widget.RecyclerView, newState: Int) {
//                when(newState){
//                    RecyclerView.SCROLL_STATE_IDLE->{
//                        println("idel")
//                    }
//                    RecyclerView.SCROLL_STATE_DRAGGING->{
//                        println("drag")
//                    }
//                    RecyclerView.SCROLL_STATE_SETTLING->{
//                        println("setting")
//                    }
//                }
                if(newState== androidx.recyclerview.widget.RecyclerView.SCROLL_STATE_IDLE){
                    //是否最后一条已经显示
                    val layoutManager = recyclerView.layoutManager
                    if(layoutManager is androidx.recyclerview.widget.LinearLayoutManager){
                        val manager: androidx.recyclerview.widget.LinearLayoutManager = layoutManager
                        val lastPosition = manager.findLastVisibleItemPosition()
                        if(lastPosition==adapter.itemCount-1){
                            //最后一条已经显示了
                            presenter.loadMore(adapter.itemCount-1)
                        }
                    }
                }
            }

//            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
//                println("onscrolled dx=$dx dy=$dy")
//            }
        })
    }

    override fun initData() {
        //初始化数据
        presenter.loadDatas()
    }
    /**
     * 获取适配器adapter
     */
    abstract fun getSpecialAdapter():BaseListAdapter<ITEMBEAN,ITEMVIEW>
    /**
     * 获取presenter
     */
    abstract fun getSpecialPresenter():BaseListPresenter
    /**
     * 从返回结果中获取列表数据集合
     */
    abstract fun getList(response: RESPONSE?): List<ITEMBEAN>?
}