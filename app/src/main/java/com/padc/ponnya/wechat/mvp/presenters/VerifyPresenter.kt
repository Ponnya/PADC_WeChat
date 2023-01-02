package com.padc.ponnya.wechat.mvp.presenters

import com.padc.ponnya.wechat.mvp.views.VerifyView

interface VerifyPresenter : BasePresenter<VerifyView> {
    fun onTapVerify(phone: String, otp: String)
    fun onTapBack()
}