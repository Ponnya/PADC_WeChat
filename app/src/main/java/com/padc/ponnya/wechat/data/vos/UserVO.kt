package com.padc.ponnya.wechat.data.vos

data class UserVO(
    val name: String = "",

    val profilePic: String = "",

    val userId: String = "",

    val message: String = "",

    val file: String = "",

    val timestamp: Long = 0L,

    var lastMessage: String = "",

    var lastMessageSentTime: Long = 0L,

    var sentBy: String = "",
)
