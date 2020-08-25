package com.hc.kotlinvideo.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hc.kotlinvideo.widget.YueDanItemView

/**
 * Created by hcw  on 2020/8/25
 * 类描述：
 * all rights reserved
 */
class YueDanAdapter : RecyclerView.Adapter<YueDanAdapter.YueDanHolder>() {
    class YueDanHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YueDanHolder {
        return YueDanHolder(YueDanItemView(parent?.context))
    }

    override fun getItemCount(): Int {
        return  20
    }

    override fun onBindViewHolder(holder: YueDanHolder, position: Int) {
    }

}