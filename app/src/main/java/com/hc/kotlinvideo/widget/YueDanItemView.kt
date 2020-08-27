package com.hc.kotlinvideo.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.hc.kotlinvideo.R
import com.hc.kotlinvideo.model.YueDanBean
import kotlinx.android.synthetic.main.item_home.view.*
import kotlinx.android.synthetic.main.item_home.view.title
import kotlinx.android.synthetic.main.item_yuedan.view.*

/**
 * Created by hcw  on 2020/8/25
 * 类描述： 自定义 View
 * all rights reserved
 */
class YueDanItemView :RelativeLayout {

    /**
     * 条目view的控件初始化
     */
    fun setData(data: YueDanBean.PlayListsBean) {
        //歌单名称
        title.text = data.title
        //创建者
        author_name.text = data.creator?.nickName
        //歌曲个数
        count.text = data.videoCount.toString()
        //背景
        Glide.with(this).load(data.playListBigPic).into(yuedan_bg)
        //创建者头像
        Glide.with(this).load(data.creator?.largeAvatar).into(author_image)

    }


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