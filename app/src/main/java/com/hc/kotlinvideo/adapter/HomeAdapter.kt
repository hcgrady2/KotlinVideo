package com.hc.kotlinvideo.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hc.kotlinvideo.model.HomeItemBean
import com.hc.kotlinvideo.widget.HomeItemView
import com.hc.kotlinvideo.widget.LoadMoreView

/**
 * Created by hcw  on 2020/8/10
 * 类描述：
 * all rights reserved
 */
/**
 * 首页列表Adapter
 */

/**
 * 首页列表Adapter
 */
class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeHolder>() {
    private var list = ArrayList<HomeItemBean>()

    fun setData(list: List<HomeItemBean>) {
        this.list.clear()
        this.list.addAll(list);
        notifyDataSetChanged()
    }

    fun loadMore(list:List<HomeItemBean>){
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    class HomeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        if (viewType == 1) {
            //最后一条
            return HomeHolder(LoadMoreView(parent?.context))
        } else {
            //普通条目
            return HomeHolder(HomeItemView(parent?.context))
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (position == list.size) {
            //最后一条，则显示加载更多
            return 1
        } else {
            //普通条目
            return 0
        }
    }

    override fun getItemCount(): Int {
        return list.size + 1
    }

    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
        //如果是最后一条 不需要刷新view
        if (position == list.size) return
        val data = list.get(position)
        val itemView = holder.itemView as HomeItemView
        itemView.setData(data)
    }
}
//class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeHolder>() {
//    //创建list，不需要 HomeFragment 维护
//    private var list = ArrayList<HomeItemBean>()
//
//
//    class HomeHolder(itemView:View):RecyclerView.ViewHolder(itemView){
//
//    }
//
//    //更新数据操作
//    fun updateList(list2:List<HomeItemBean>){
//        this.list.clear()
//        this.list.addAll(list2)
//
//        notifyDataSetChanged()
//    }
//
//
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
//        return HomeHolder(HomeItemView(parent.context))
//    }
//
//    override fun getItemCount(): Int {
//        return list.size
//    }
//
//
//    //数据绑定
//    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
//        //tiao'm
//    }
//}