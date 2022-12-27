package com.padc.ponnya.wechat.mvp.presenters

import com.padc.ponnya.wechat.mvp.views.WelcomeView

interface WelcomePresenter : BasePresenter<WelcomeView> {
    fun onTapLogin()
}