package com.hc.kotlinvideo.presenter.impl

import com.hc.kotlinvideo.model.MvAreaBean
import com.hc.kotlinvideo.net.MvAreaRequest
import com.hc.kotlinvideo.net.ResponseHandler
import com.hc.kotlinvideo.presenter.`interface`.MvPresenter
import com.hc.kotlinvideo.view.MvView


/**
 * ClassName:MvPresenterImpl
 * Description:
 */
class MvPresenterImpl(var mvView: MvView): MvPresenter, ResponseHandler<List<MvAreaBean>> {
    override fun onError(type: Int, msg: String?) {
        mvView.onError(msg)
    }

    override fun onSuccess(type: Int, result: List<MvAreaBean>) {
        mvView.onSuccess(result)
    }

    /**
     * 加载区域数据
     */
    override fun loadDatas() {
        MvAreaRequest(this).excute()
    }
}