package com.padc.ponnya.wechat.mvp.views

import com.padc.ponnya.wechat.data.vos.UserVO

interface ChatRoomView : BaseView {
    fun showChatMessage(chatMessage: List<UserVO>)
    fun openGallery()
}