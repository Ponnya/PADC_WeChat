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
                        duration = momentVO.postedTime.let { time -> return@let currentTime - time })
                }
                mView.showData(momentList.reversed())
            },
            onFailure = { mView.showError(it) }
        )
    }

    override fun onTapLike(phone: String, postedTime: Long) {
        mModel.likeCountIncreaseOrDecrease(phone, postedTime.toString()) { mView.showError(it) }
    }
}