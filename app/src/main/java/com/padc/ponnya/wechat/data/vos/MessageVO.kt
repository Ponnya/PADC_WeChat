package com.padc.ponnya.wechat.data.vos

data class MessageVO(
    val name: String = "",

    val profilePic: String = "",

    val userId: String = "",

    val message: String = "",

    val file: String = "",

    val timestamp: Long = 0L,
)
