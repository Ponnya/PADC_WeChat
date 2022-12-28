package com.padc.ponnya.wechat.mvp.presenters.impl

import androidx.lifecycle.LifecycleOwner
import com.padc.ponnya.wechat.mvp.presenters.AbstractBasePresenter
import com.padc.ponnya.wechat.mvp.presenters.VerifyPresenter
import com.padc.ponnya.wechat.mvp.views.VerifyView

class VerifyPresenterImpl : AbstractBasePresenter<VerifyView>(), VerifyPresenter {
    override fun onTapVerify() {
        mView.navigateToSignUp()
    }

    override fun onTapBack() {
        mView.navigateToWelcomeScreen()
    }

    override fun onUiReady(owner: LifecycleOwner) {

    }
}