package com.padc.ponnya.wechat.mvp.presenters

import android.graphics.Bitmap
import com.padc.ponnya.wechat.delegates.SelectedImageDelegate
import com.padc.ponnya.wechat.mvp.views.NewMomentView

interface NewMomentPresenter : BasePresenter<NewMomentView>, SelectedImageDelegate {
    fun onTapCreate(text: String, imageList: List<Bitmap>)
    fun onTapClose()
}