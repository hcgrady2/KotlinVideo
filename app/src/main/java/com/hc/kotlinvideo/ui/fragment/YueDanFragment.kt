package com.hc.kotlinvideo.ui.fragment

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.hc.kotlinvideo.R
import com.hc.kotlinvideo.adapter.YueDanAdapter
import com.hc.kotlinvideo.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_list.*

/**
 * Created by hcw  on 2020/8/10
 * 类描述：
 * all rights reserved
 */
class YueDanFragment : BaseFragment() {


    val adapter by lazy {
        YueDanAdapter()
    }

    override fun initView(): View? {
        return  View.inflate(context, R.layout.fragment_list,null)
    }

    override fun initListener() {
        recycler_view.layoutManager = LinearLayoutManager(context)
        recycler_view.adapter = adapter
    }


}