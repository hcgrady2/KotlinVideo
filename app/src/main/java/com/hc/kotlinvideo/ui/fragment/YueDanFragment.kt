package com.hc.kotlinvideo.ui.fragment

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.hc.kotlinvideo.R
import com.hc.kotlinvideo.adapter.YueDanAdapter
import com.hc.kotlinvideo.base.BaseFragment
import com.hc.kotlinvideo.model.YueDanBean
import com.hc.kotlinvideo.presenter.`interface`.YueDanPresenter
import com.hc.kotlinvideo.presenter.impl.YueDanPresenterImpl
import com.hc.kotlinvideo.view.YueDanView
import kotlinx.android.synthetic.main.fragment_list.*

/**
 * Created by hcw  on 2020/8/10
 * 类描述：
 * all rights reserved
 */
class YueDanFragment : BaseFragment(), YueDanView {
    val adapter by lazy {
        YueDanAdapter()
    }
    val presenter by lazy {
        YueDanPresenterImpl(this)
    }

    override fun initView(): View? {
        return  View.inflate(context, R.layout.fragment_list,null)
    }

    override fun initListener() {
        recycler_view.layoutManager = LinearLayoutManager(context)
        recycler_view.adapter = adapter
    }


    override fun initData() {
        super.initData()

        presenter.loadDatas(context)
    }

    override fun onError(message: String?) {
        myToast("加载数据失败")
    }

    override fun loadSuccess(response: YueDanBean?) {
        response?.playLists?.let { adapter.updateList(it) }
    }

    override fun loadMore(response: YueDanBean?) {




    }

}