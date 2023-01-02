package com.padc.ponnya.wechat.mvp.presenters

import com.padc.ponnya.wechat.mvp.views.SignUpView

interface SignUpPresenter : BasePresenter<SignUpView> {
    fun onTapSignUp(
        phone: String,
        name: String,
        day: String,
        month: String,
        year: String,
        gender: Long,
        password: String,
        termAndService: Boolean
    )

    fun onTapBack()
}