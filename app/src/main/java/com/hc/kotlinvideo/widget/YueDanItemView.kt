package com.hc.kotlinvideo.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.hc.kotlinvideo.R

/**
 * Created by hcw  on 2020/8/25
 * 类描述： 自定义 View
 * all rights reserved
 */
class YueDanItemView :RelativeLayout {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )


    init {
        View.inflate(context, R.layout.item_yuedan,this)
    }



}