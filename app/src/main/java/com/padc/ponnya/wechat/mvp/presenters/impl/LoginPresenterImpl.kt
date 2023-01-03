package com.padc.ponnya.wechat.mvp.presenters.impl

import androidx.lifecycle.LifecycleOwner
import com.padc.ponnya.wechat.mvp.presenters.AbstractBasePresenter
import com.padc.ponnya.wechat.mvp.presenters.LoginPresenter
import com.padc.ponnya.wechat.mvp.views.LoginView
import com.padc.ponnya.wechat.utils.ERROR_INVALID_PASSWORD
import com.padc.ponnya.wechat.utils.ERROR_INVALID_PHONE

class LoginPresenterImpl : AbstractBasePresenter<LoginView>(), LoginPresenter {
    override fun onTapBack() {
        mView.navigateToWelcome()
    }

    override fun onTapLoginBtn(phone: String, password: String) {
        if (phone.isEmpty()) mView.showPhoneError(ERROR_INVALID_PHONE)
        if (password.isEmpty()) mView.showPasswordError(ERROR_INVALID_PASSWORD)
        if (phone.isNotEmpty() && password.isNotEmpty())
            mModel.login(
                phone = phone,
                password = password,
                onSuccess = { mView.navigateToHomeScreen() },
                onFailure = { mView.showError(it) }
            )
    }

    override fun onUiReady(owner: LifecycleOwner) {

    }
}