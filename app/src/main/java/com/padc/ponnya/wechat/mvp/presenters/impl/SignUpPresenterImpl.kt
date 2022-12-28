package com.padc.ponnya.wechat.mvp.presenters.impl

import androidx.lifecycle.LifecycleOwner
import com.padc.ponnya.wechat.mvp.presenters.AbstractBasePresenter
import com.padc.ponnya.wechat.mvp.presenters.SignUpPresenter
import com.padc.ponnya.wechat.mvp.views.SignUpView

class SignUpPresenterImpl : AbstractBasePresenter<SignUpView>(), SignUpPresenter {
    override fun onTapBack() {
        mView.navigateToVerifyScreen()
    }

    override fun onUiReady(owner: LifecycleOwner) {

    }
}