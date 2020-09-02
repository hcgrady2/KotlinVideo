package com.hc.kotlinvideo.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.hc.kotlinvideo.ui.fragment.DefaultFragment


/**
 * ClassName:VideoPagerAdapter
 * Description:
 */
class VideoPagerAdapter(fm: androidx.fragment.app.FragmentManager?) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): androidx.fragment.app.Fragment {
        return DefaultFragment()
    }

    override fun getCount(): Int {
       return 3
    }
}