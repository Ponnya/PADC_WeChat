package com.padc.ponnya.wechat.mvp.presenters

import com.padc.ponnya.wechat.mvp.views.SignUpView

interface SignUpPresenter : BasePresenter<SignUpView> {
    fun onTapBack()
}