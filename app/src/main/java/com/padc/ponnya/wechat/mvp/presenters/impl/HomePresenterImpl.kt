package com.padc.ponnya.wechat.mvp.presenters.impl

import androidx.lifecycle.LifecycleOwner
import com.padc.ponnya.wechat.mvp.presenters.AbstractBasePresenter
import com.padc.ponnya.wechat.mvp.presenters.HomePresenter
import com.padc.ponnya.wechat.mvp.views.HomeView

class HomePresenterImpl : AbstractBasePresenter<HomeView>(), HomePresenter {
    override fun onTapAddNewMoment(): Boolean = mView.openNewMomentScreen()

    override fun onUiReady(owner: LifecycleOwner) {
    }

}