package com.padc.ponnya.wechat.mvp.presenters

import com.padc.ponnya.wechat.mvp.views.HomeView

interface HomePresenter : BasePresenter<HomeView> {
    fun onTapAddNewMoment(): Boolean
}