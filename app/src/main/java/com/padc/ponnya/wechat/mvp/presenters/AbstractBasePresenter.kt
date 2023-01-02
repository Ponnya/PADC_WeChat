package com.padc.ponnya.wechat.mvp.presenters

import androidx.lifecycle.ViewModel
import com.padc.ponnya.wechat.data.models.WeChatModel
import com.padc.ponnya.wechat.data.models.WeChatModelImpl
import com.padc.ponnya.wechat.mvp.views.BaseView

abstract class AbstractBasePresenter<T : BaseView> : BasePresenter<T>, ViewModel() {
    protected lateinit var mView: T

    protected val mModel: WeChatModel = WeChatModelImpl

    override fun initView(view: T) {
        mView = view
    }
}