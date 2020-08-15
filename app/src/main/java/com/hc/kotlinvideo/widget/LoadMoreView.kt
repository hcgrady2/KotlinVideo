package com.hc.kotlinvideo.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.hc.kotlinvideo.R

/**
 * Created by hcw  on 2020/8/15
 * 类描述：
 * all rights reserved
 */
/**
 * 列表加载更多项
 */
class LoadMoreView : RelativeLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        View.inflate(context, R.layout.view_loadmore, this)
    }
}