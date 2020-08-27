package com.hc.kotlinvideo.presenter.impl

import android.content.Context
import com.hc.kotlinvideo.base.BaseListPresenter
import com.hc.kotlinvideo.model.YueDanBean
import com.hc.kotlinvideo.net.ResponseHandler
import com.hc.kotlinvideo.net.YueDanRequest
import com.hc.kotlinvideo.presenter.`interface`.YueDanPresenter
import com.hc.kotlinvideo.ui.fragment.YueDanFragment
import com.hc.kotlinvideo.view.YueDanView

/**
 * Created by hcw  on 2020/8/26
 * 类描述：
 * all rights reserved
 */

class YueDanPresenterImpl(var yueDanView: YueDanView):YueDanPresenter, ResponseHandler<YueDanBean> {
    override fun loadDatas(context: Context?) {
        YueDanRequest(YueDanPresenter.TYPE_INIT_OR_REFRESH,0,this).execute()
    }




    override fun loadDataMore(lastPosition: Int, context: Context?) {
    }



    override fun onError(type: Int, msg: String?) {
        yueDanView.onError(msg)
    }


    override fun onSuccess(type: Int, result: YueDanBean) {
        if (type == YueDanPresenter.TYPE_INIT_OR_REFRESH){
            yueDanView.loadSuccess(result)
        }else if(type== BaseListPresenter.TYPE_LOAD_MORE){
            yueDanView?.loadMore(result)
        }
    }





}