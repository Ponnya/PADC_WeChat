package com.padc.ponnya.wechat.mvp.presenters.impl

import androidx.lifecycle.LifecycleOwner
import com.padc.ponnya.wechat.mvp.presenters.AbstractBasePresenter
import com.padc.ponnya.wechat.mvp.presenters.VerifyPresenter
import com.padc.ponnya.wechat.mvp.views.VerifyView
import com.padc.ponnya.wechat.utils.ERROR_INVALID_OTP
import com.padc.ponnya.wechat.utils.ERROR_INVALID_PHONE
import com.padc.ponnya.wechat.utils.OTP

class VerifyPresenterImpl : AbstractBasePresenter<VerifyView>(), VerifyPresenter {


    override fun onTapVerify(phone: String, otp: String) {
        if (phone.isNullOrBlank()) {
            mView.showPhoneError(ERROR_INVALID_PHONE)
        } else if (otp == OTP) {
            mView.navigateToSignUp(phone)
        } else {
            mView.showError(ERROR_INVALID_OTP)
        }
    }

    override fun onTapBack() {
        mView.navigateToWelcomeScreen()
    }

    override fun onUiReady(owner: LifecycleOwner) {

    }
}