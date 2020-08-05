package com.hc.kotlinvideo.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.hc.kotlinvideo.R
import com.hc.kotlinvideo.base.BaseActivity
import com.hc.kotlinvideo.util.ToolBarManager
import org.jetbrains.anko.find

class MainActivity : BaseActivity() ,ToolBarManager{

    override val toolbar by lazy {
        find<Toolbar>(R.id.tool_bar)
    }


    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
        super.initData()
        initMainToolBar()
    }
}