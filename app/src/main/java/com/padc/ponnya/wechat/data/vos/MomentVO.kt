package com.padc.ponnya.wechat.data.vos

class MomentVO(

    val text: String? = "",

    val images: List<String>? = listOf(),

    val likeCount: Int? = 0,

    val commentCount: Int? = 0,

    val postedTime: String? = "",
)
