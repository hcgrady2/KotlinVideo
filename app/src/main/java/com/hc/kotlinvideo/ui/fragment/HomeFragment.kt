package com.hc.kotlinvideo.ui.fragment

import android.view.Gravity
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.hc.kotlinvideo.R
import com.hc.kotlinvideo.adapter.HomeAdapter
import com.hc.kotlinvideo.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by hcw  on 2020/8/10
 * 类描述：
 * all rights reserved
 */
class HomeFragment : BaseFragment() {
    override fun initView(): View? {
        return  View.inflate(context,R.layout.fragment_home,null)
    }

    override fun initListener() {
        super.initListener()
        recycler_view.layoutManager = LinearLayoutManager(context)
        //条目适配
        val adapter = HomeAdapter()
        recycler_view.adapter = adapter

    }

}