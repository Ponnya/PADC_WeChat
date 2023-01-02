package com.padc.ponnya.wechat.mvp.views

interface VerifyView : BaseView {
    fun navigateToSignUp(phone: String)
    fun navigateToWelcomeScreen()
    fun showPhoneError(error: String)
}