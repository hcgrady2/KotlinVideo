package com.hc.kotlinvideo.model

/**
 * Created by hcw  on 2020/8/15
 * 类描述：
 * all rights reserved
 */

/**
 * home界面每个条目的bean
 */
data class HomeBean(
    val songlist: List<HomeItemBean>
)

data class HomeItemBean(
    val albums_total: String,
    val aliasname: String,
    val area: String,
    val artist_id: String,
    val avatar_big: String,
    val avatar_middle: String,
    val avatar_mini: String,
    val avatar_s1000: String,
    val avatar_s180: String,
    val avatar_s500: String,
    val avatar_small: String,
    val birth: String,
    val bloodtype: String,
    val company: String,
    val constellation: String,
    val country: String,
    val del_status: String,
    val firstchar: String,
    val gender: String,
    val intro: String,
    val name: String,
    val piao_id: String,
    val songs_total: String,
    val source: String,
    val stature: String,
    val ting_uid: String,
    val translatename: String,
    val url: String,
    val weight: String,
    val title: String,
    val author: String,
    val album_500_500: String
)