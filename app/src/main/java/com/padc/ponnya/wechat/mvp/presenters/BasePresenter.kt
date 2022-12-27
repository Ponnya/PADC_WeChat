package com.padc.ponnya.wechat.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padc.ponnya.wechat.mvp.views.BaseView

interface BasePresenter<T : BaseView> {
    fun onUiReady(owner: LifecycleOwner)
    fun initView(view: T)
}