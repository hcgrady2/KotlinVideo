package com.hc.kotlinvideo.ui.fragment

import com.hc.kotlinvideo.adapter.MvListAdapter
import com.hc.kotlinvideo.base.BaseListAdapter
import com.hc.kotlinvideo.base.BaseListFragment
import com.hc.kotlinvideo.base.BaseListPresenter
import com.hc.kotlinvideo.model.MvPagerBean
import com.hc.kotlinvideo.model.VideoPlayBean
import com.hc.kotlinvideo.model.VideosBean
import com.hc.kotlinvideo.presenter.impl.MvListPresenterImpl
import com.hc.kotlinvideo.view.MvListView
import com.itheima.player.widget.MvItemView


/**
 * ClassName:MvPagerFragment
 * Description:mv界面每一个页面fragment
 */
class MvPagerFragment: BaseListFragment<MvPagerBean, VideosBean, MvItemView>(), MvListView {
    var code:String? = null
    override fun init() {
        code = arguments?.getString("args")
    }
    override fun getSpecialAdapter(): BaseListAdapter<VideosBean, MvItemView> {
        return MvListAdapter()
    }

    override fun getSpecialPresenter(): BaseListPresenter {
        return MvListPresenterImpl(code!!,this)
    }

    override fun getList(response: MvPagerBean?): List<VideosBean>? {
        return response?.videos
    }

    override fun initListener() {
        super.initListener()
        //设置条目点击事件监听函数
        adapter.setMyListener{
            val videoPlayBean = VideoPlayBean(it.id,it.title,it.url)
            //跳转到视频播放界面
           // startActivity<JiecaoVideoPlayerActivity>("item" to videoPlayBean)
           // startActivity()
        }
    }
}