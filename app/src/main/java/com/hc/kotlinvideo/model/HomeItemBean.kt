package com.hc.kotlinvideo.model

/**
 * ClassName:HomeItemBean
 * Description:home界面每个条目的bean
 * Kotlin 中数据类，自带 get set
 */
data class HomeItemBean(var type: String, var id: Int,
                        var title: String, var description: String?,
                        var posterPic: String?,var thumbnailPic: String?,
                        var url: String,var hdUrl: String?,var videoSize: Int,
                        var hdVideoSize: Int,var uhdVideoSize: Int,var status: Int,
                        var traceUrl: String?,var clickUrl: String?,var uhdUrl: String?)
