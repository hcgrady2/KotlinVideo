package com.hc.kotlinvideo.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.hc.kotlinvideo.R
import com.hc.kotlinvideo.ui.activity.AboutActivity
import org.jetbrains.anko.support.v4.toast

/**
 * Created by hcw  on 2020/8/5
 * 类描述：
 * all rights reserved
 */
class SettingFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.setting,rootKey)
    }


    override fun onPreferenceTreeClick(preference: Preference?): Boolean {
        val key = preference?.key

        if ("about".equals(key)){
            activity?.startActivity(Intent(activity,AboutActivity::class.java))
        }

        return super.onPreferenceTreeClick(preference)
    }
}