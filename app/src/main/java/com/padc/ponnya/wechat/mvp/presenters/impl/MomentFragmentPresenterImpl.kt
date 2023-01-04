package com.padc.ponnya.wechat.mvp.presenters.impl

import androidx.lifecycle.LifecycleOwner
import com.padc.ponnya.wechat.mvp.presenters.AbstractBasePresenter
import com.padc.ponnya.wechat.mvp.presenters.MomentFragmentPresenter
import com.padc.ponnya.wechat.mvp.views.MomentFragmentView
import java.util.*

class MomentFragmentPresenterImpl : AbstractBasePresenter<MomentFragmentView>(),
    MomentFragmentPresenter {
    override fun onUiReady(owner: LifecycleOwner) {
        mModel.getMoments(
            onSuccess = {
                val currentTime = Calendar.getInstance().time.time
                val momentList = it.map { momentVO ->
                    momentVO.copy(
                        postedTime = momentVO.postedTime?.let { time -> return@let currentTime - time }
                            ?: run { return@run 0L })
                }
                mView.showData(momentList.reversed())
            },
            onFailure = { mView.showError(it) }
        )
    }
}