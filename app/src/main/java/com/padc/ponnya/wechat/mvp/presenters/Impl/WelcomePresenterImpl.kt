package com.padc.ponnya.wechat.mvp.presenters.Impl

import androidx.lifecycle.LifecycleOwner
import com.padc.ponnya.wechat.mvp.presenters.AbstractBasePresenter
import com.padc.ponnya.wechat.mvp.presenters.WelcomePresenter
import com.padc.ponnya.wechat.mvp.views.WelcomeView

class WelcomePresenterImpl : AbstractBasePresenter<WelcomeView>(), WelcomePresenter {
    override fun onTapLogin() {
        mView.navigateToLogin()
    }

    override fun onUiReady(owner: LifecycleOwner) {

    }
}