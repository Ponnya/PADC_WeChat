package com.padc.ponnya.wechat.mvp.presenters.impl

import androidx.lifecycle.LifecycleOwner
import com.padc.ponnya.wechat.mvp.presenters.AbstractBasePresenter
import com.padc.ponnya.wechat.mvp.presenters.ChatFragmentPresenter
import com.padc.ponnya.wechat.mvp.views.ChatFragmentView

class ChatFragmentPresenterImpl : AbstractBasePresenter<ChatFragmentView>(), ChatFragmentPresenter {
    override fun onUiReady(owner: LifecycleOwner) {
        mModel.getChatList({ mView.showChatList(it) }) { mView.showError(it) }
    }

    override fun onTapChat(receiver: String) {
        mView.openChatRoom(receiver)
    }
}