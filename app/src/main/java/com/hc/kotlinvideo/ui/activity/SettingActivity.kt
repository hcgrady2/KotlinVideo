package com.hc.kotlinvideo.ui.activity

import androidx.appcompat.widget.Toolbar
import com.hc.kotlinvideo.R
import com.hc.kotlinvideo.base.BaseActivity
import com.hc.kotlinvideo.util.ToolBarManager
import org.jetbrains.anko.find

/**
 * Created by hcw  on 2020/8/5
 * 类描述：
 * all rights reserved
 */
class SettingActivity : BaseActivity() ,ToolBarManager{

    override val toolbar by lazy {
        find<Toolbar>(R.id.tool_bar)
    }
    override fun getLayoutId(): Int {
        return  R.layout.activity_setting
    }

    override fun initData() {
        super.initData()
        initSettingToolBar()
    }
}