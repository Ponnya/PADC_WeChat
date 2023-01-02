package com.padc.ponnya.wechat.mvp.views

interface SignUpView : BaseView {
    fun navigateToHomeScreen()
    fun showNameError(error: String)
    fun showDayError(error: String)
    fun showMonthError(error: String)
    fun showYearError(error: String)
    fun showPasswordError(error: String)
    fun showTermAndServiceError(error: String)
    fun navigateToVerifyScreen()
}