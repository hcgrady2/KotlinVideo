package com.itheima.player.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.hc.kotlinvideo.R
import com.hc.kotlinvideo.model.VideosBean
import kotlinx.android.synthetic.main.item_home.view.*
import kotlinx.android.synthetic.main.item_mv.view.*
import kotlinx.android.synthetic.main.item_mv.view.bg
import kotlinx.android.synthetic.main.item_mv.view.title


/**
 * ClassName:MvItemView
 * Description:mv每一个界面条目view
 */
class MvItemView:RelativeLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    init {
        View.inflate(context, R.layout.item_mv,this)
    }

    /**
     * 适配每一个条目view
     */
    fun setData(data: VideosBean) {
        //歌手名称
        artist.text = data.artistName
        //歌曲名称
        title.text = data.title
        //背景图
        Glide.with(this).load(data.playListPic).into(bg)

    }
}