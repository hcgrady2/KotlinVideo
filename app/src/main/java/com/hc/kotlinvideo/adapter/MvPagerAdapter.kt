package com.hc.kotlinvideo.adapter

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.hc.kotlinvideo.model.MvAreaBean
import com.hc.kotlinvideo.ui.fragment.MvPagerFragment


/**
 * ClassName:MvPagerAdapter
 * Description:
 */
class MvPagerAdapter(val context:Context, val list:List<MvAreaBean>?, fm: androidx.fragment.app.FragmentManager?) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): androidx.fragment.app.Fragment {
        //第一种数据传递方式
//        val fragment = MvPagerFragment()
        val bundle = Bundle()
        bundle.putString("args",list?.get(position)?.code)
//        fragment.arguments = bundle
        //第二种fragment传递数据方式
        val fragment = androidx.fragment.app.Fragment.instantiate(context,
            MvPagerFragment::class.java.name,bundle)
        return fragment
    }

    override fun getCount(): Int {
        return list?.size?:0//如果不为null返回list.size 为空返回0
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return list?.get(position)?.name
    }
}