package com.padc.ponnya.wechat.mvp.presenters

import com.padc.ponnya.wechat.delegates.ChatListDelegate
import com.padc.ponnya.wechat.mvp.views.ChatFragmentView

interface ChatFragmentPresenter : BasePresenter<ChatFragmentView>, ChatListDelegate