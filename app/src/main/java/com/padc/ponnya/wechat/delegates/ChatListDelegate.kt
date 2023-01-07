package com.padc.ponnya.wechat.delegates

interface ChatListDelegate {
    fun onTapChat(receiver: String, name: String, profilePic: String)
}