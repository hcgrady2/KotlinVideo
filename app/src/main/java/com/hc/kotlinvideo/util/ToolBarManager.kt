package com.hc.kotlinvideo.util

import android.content.Intent
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.hc.kotlinvideo.R
import com.hc.kotlinvideo.ui.activity.SettingActivity

/**
 * Created by hcw  on 2020/8/5
 * 类描述：所有界面 ToolBar 管理
 * all rights reserved
 */
interface ToolBarManager {

    //interface 中 toolbar 可以不初始化
    val toolbar:Toolbar

    //并且 kotlin 中的 interface 可以有实现
    fun initMainToolBar() {
        toolbar.setTitle("Kotlin Video")
        toolbar.inflateMenu(R.menu.main)
        //设置 menu 点击事件
        toolbar.setOnMenuItemClickListener(object : Toolbar.OnMenuItemClickListener {
            override fun onMenuItemClick(item: MenuItem?): Boolean {

                when (item?.itemId) {
                    R.id.setting -> {
                        //Toast.makeText(toolbar.context,"setting",Toast.LENGTH_LONG).show()
                        //跳转设置界面
                        toolbar.context.startActivity(Intent(toolbar.context,SettingActivity::class.java))
                    }
                }

                return true;
            }
        })


        //如果 java 接口中只有一个未实现方法，可以省略接口对象，直接覆写方法，大括号表示
//        toolbar.setOnMenuItemClickListener {
//          true
//        }

    }


    fun  initSettingToolBar(){
        toolbar.setTitle("设置界面")
    }

}