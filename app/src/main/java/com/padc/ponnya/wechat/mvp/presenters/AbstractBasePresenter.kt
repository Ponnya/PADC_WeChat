package com.padc.ponnya.wechat.mvp.presenters

import androidx.lifecycle.ViewModel
import com.padc.ponnya.wechat.mvp.views.BaseView

abstract class AbstractBasePresenter<T : BaseView> : BasePresenter<T>, ViewModel() {
    protected lateinit var mView: T

    override fun initView(view: T) {
        mView = view
    }
}