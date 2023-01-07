package com.padc.ponnya.wechat.mvp.presenters.impl

import androidx.lifecycle.LifecycleOwner
import com.padc.ponnya.wechat.mvp.presenters.AbstractBasePresenter
import com.padc.ponnya.wechat.mvp.presenters.ChatRoomPresenter
import com.padc.ponnya.wechat.mvp.views.ChatRoomView

class ChatRoomPresenterImpl : AbstractBasePresenter<ChatRoomView>(), ChatRoomPresenter {
    override fun onUiReady(owner: LifecycleOwner, receiver: String) {
        mModel.getChatMessage(receiver, {
            mView.showChatMessage(it)
        }) {
            mView.showError(it)
        }
    }

    override fun onUiReady(owner: LifecycleOwner) {

    }

    override fun onTapSend(
        receiver: String,
        message: String,
        file: String,
    ) {
        mModel.insertMessage(receiver, message, file)
    }

}