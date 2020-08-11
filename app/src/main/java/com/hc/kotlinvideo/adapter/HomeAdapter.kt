package com.hc.kotlinvideo.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hc.kotlinvideo.model.HomeItemBean
import com.hc.kotlinvideo.widget.HomeItemView

/**
 * Created by hcw  on 2020/8/10
 * 类描述：
 * all rights reserved
 */
class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeHolder>() {
    //创建list，不需要 HomeFragment 维护
    private var list = ArrayList<HomeItemBean>()


    class HomeHolder(itemView:View):RecyclerView.ViewHolder(itemView){

    }

    //更新数据操作
    fun updateList(list2:List<HomeItemBean>){
        this.list.clear()
        this.list.addAll(list2)

        notifyDataSetChanged()
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        return HomeHolder(HomeItemView(parent.context))
    }

    override fun getItemCount(): Int {
        return list.size
    }


    //数据绑定
    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
        //tiao'm
    }
}