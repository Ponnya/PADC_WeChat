package com.padc.ponnya.wechat.mvp.presenters.impl

import androidx.lifecycle.LifecycleOwner
import com.padc.ponnya.wechat.mvp.presenters.AbstractBasePresenter
import com.padc.ponnya.wechat.mvp.presenters.LoginPresenter
import com.padc.ponnya.wechat.mvp.views.LoginView

class LoginPresenterImpl : AbstractBasePresenter<LoginView>(), LoginPresenter {
    override fun onTapBack() {
        mView.navigateToWelcome()
    }

    override fun onTapLoginBtn() {
        mView.navigateToHomeScreen()
    }

    override fun onUiReady(owner: LifecycleOwner) {

    }
}