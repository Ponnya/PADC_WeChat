package com.padc.ponnya.wechat.mvp.presenters

import com.padc.ponnya.wechat.mvp.views.LoginView

interface LoginPresenter : BasePresenter<LoginView> {
    fun onTapBack()
}