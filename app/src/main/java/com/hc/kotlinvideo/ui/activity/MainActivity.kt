package com.hc.kotlinvideo.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.hc.kotlinvideo.R
import com.hc.kotlinvideo.base.BaseActivity
import com.hc.kotlinvideo.util.FragmentUtil
import com.hc.kotlinvideo.util.ToolBarManager
import kotlinx.android.synthetic.main.activity_main.*
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

    override fun initListener() {
        super.initListener()
        //设置 tab 切换监听
        bottomBar.setOnTabSelectListener {
            //it 代表参数 id
            val transition = supportFragmentManager.beginTransaction()
            FragmentUtil.fragmentUtil.getFragment(it)?.let { it1 ->
                transition.replace(R.id.container, it1,it.toString())
                transition.commit()
            }
        }
    }
}