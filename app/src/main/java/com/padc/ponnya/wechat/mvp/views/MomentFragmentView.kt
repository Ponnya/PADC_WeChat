package com.padc.ponnya.wechat.mvp.views

import com.padc.ponnya.wechat.data.vos.MomentVO

interface MomentFragmentView : BaseView {
    fun showData(momentList: List<MomentVO>)
}