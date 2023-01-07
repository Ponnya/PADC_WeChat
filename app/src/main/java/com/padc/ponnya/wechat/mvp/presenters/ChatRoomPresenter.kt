package com.padc.ponnya.wechat.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padc.ponnya.wechat.mvp.views.ChatRoomView

interface ChatRoomPresenter : BasePresenter<ChatRoomView> {
    fun onUiReady(owner: LifecycleOwner, receiver: String)
}