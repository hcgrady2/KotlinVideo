package com.hc.kotlinvideo.adapter

import android.content.Context
import com.hc.kotlinvideo.base.BaseListAdapter
import com.hc.kotlinvideo.model.VideosBean
import com.itheima.player.widget.MvItemView


/**
 * ClassName:MvListAdapter
 * Description:mv界面每一个list列表的适配器
 */
class MvListAdapter: BaseListAdapter<VideosBean, MvItemView>() {
    override fun refreshItemView(itemView: MvItemView, data: VideosBean) {
        itemView.setData(data)
    }

    override fun getItemView(context: Context?): MvItemView {
        return MvItemView(context)
    }
}