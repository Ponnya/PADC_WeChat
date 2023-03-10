package com.padc.ponnya.wechat.mvp.presenters.impl

import androidx.lifecycle.LifecycleOwner
import com.padc.ponnya.wechat.mvp.presenters.AbstractBasePresenter
import com.padc.ponnya.wechat.mvp.presenters.WelcomePresenter
import com.padc.ponnya.wechat.mvp.views.WelcomeView

class WelcomePresenterImpl : AbstractBasePresenter<WelcomeView>(), WelcomePresenter {
    override fun onTapLogin() {
        mView.navigateToLogin()
    }

    override fun onTapSignUp() {
        mView.nvigateToVerify()
    }

    override fun onUiReady(owner: LifecycleOwner) {

    }
}