package com.padc.ponnya.wechat.mvp.views

interface LoginView : BaseView {
    fun navigateToWelcome()
    fun navigateToHomeScreen()
    fun showPhoneError(error: String)
    fun showPasswordError(error: String)
}