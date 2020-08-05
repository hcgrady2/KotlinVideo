package com.hc.kotlinvideo.ui.fragment

import android.os.Bundle
import android.preference.PreferenceFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hc.kotlinvideo.R

/**
 * Created by hcw  on 2020/8/5
 * 类描述：todo,PreferenceFragment 过时处理
 * all rights reserved
 */
class SettingFragment : PreferenceFragment() {

    override fun onCreateView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        addPreferencesFromResource(R.xml.setting)
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}