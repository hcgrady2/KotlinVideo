package com.hc.kotlinvideo.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.hc.kotlinvideo.R
import com.hc.kotlinvideo.model.HomeItemBean
import java.util.jar.Attributes
import kotlinx.android.synthetic.main.item_home.view.*

/**
 * Created by hcw  on 2020/8/10
 * 类描述：
 * all rights reserved
 */

class HomeItemView : RelativeLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        View.inflate(context, R.layout.item_home, this)
    }

    /**
     * 刷新条目view数据
     */
    fun setData(data: HomeItemBean) {
        //歌曲名称
        title.setText(data.title)
        //简介
        desc.setText(data.author)
        //背景图片
    }
}


//class HomeItemView : RelativeLayout{
//    //new
//    constructor(context: Context?):super(context)
//    //layout
//    constructor(context: Context?,attrs:AttributeSet?):super(context,attrs)
//    //theme
//    constructor(context: Context?,attrs: AttributeSet?,defStyle:Int):super(context,attrs,defStyle)
//
//
//    //初始化，无论调用主构造还是次构造，都会执行，但是 init 只能访问主构造函数里面的参数
//    init {
//        //通过指定 root,加载的布局会直接添加到 root 里面，否则需要手动 addView
//        View.inflate(context, R.layout.item_home,this)
//    }
//
//
//}