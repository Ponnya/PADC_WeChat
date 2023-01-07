package com.padc.ponnya.wechat.mvp.views

import com.padc.ponnya.wechat.data.vos.UserVO

interface ChatFragmentView : BaseView {
    fun showChatList(chatList: List<UserVO>)
    fun openChatRoom(receiver: String)
}