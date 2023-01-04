package com.padc.ponnya.wechat.mvp.presenters.impl

import androidx.lifecycle.LifecycleOwner
import com.padc.ponnya.wechat.mvp.presenters.AbstractBasePresenter
import com.padc.ponnya.wechat.mvp.presenters.MomentFragmentPresenter
import com.padc.ponnya.wechat.mvp.views.MomentFragmentView

class MomentFragmentPresenterImpl : AbstractBasePresenter<MomentFragmentView>(),
    MomentFragmentPresenter {
    override fun onUiReady(owner: LifecycleOwner) {
        mModel.getMoments(
            onSuccess = { mView.showData(it.reversed()) },
            onFailure = { mView.showError(it) }
        )
    }
}