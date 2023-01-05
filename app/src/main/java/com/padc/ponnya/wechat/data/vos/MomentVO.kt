package com.padc.ponnya.wechat.data.vos

data class MomentVO(

    val text: String = "",

    val images: List<String> = listOf(),

    val likeCount: Int = 0,

    val commentCount: Int = 0,

    val postedTime: Long = 0L,

    val duration: Long = 0L,

    val momentPhone: String = "",

    val isLikeMoment: Boolean = false,
)
