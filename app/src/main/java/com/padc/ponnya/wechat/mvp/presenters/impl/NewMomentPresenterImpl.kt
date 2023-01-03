package com.padc.ponnya.wechat.mvp.presenters.impl

import android.graphics.Bitmap
import androidx.lifecycle.LifecycleOwner
import com.padc.ponnya.wechat.mvp.presenters.AbstractBasePresenter
import com.padc.ponnya.wechat.mvp.presenters.NewMomentPresenter
import com.padc.ponnya.wechat.mvp.views.NewMomentView

class NewMomentPresenterImpl : AbstractBasePresenter<NewMomentView>(), NewMomentPresenter {
    override fun onTapCreate(text: String, imageList: List<Bitmap>) {
        if (text.isNotBlank() || imageList.isNotEmpty()) {
            mModel.createMoment(
                text = text,
                imageList = imageList,
                onSuccess = { mView.closeNewMoment() },
                onFailure = { mView.showError(it) }
            )
        } else {
            mView.focusOnEditText()
        }
    }

    override fun onUiReady(owner: LifecycleOwner) {

    }

    /**
     * SelectedImageDelegate.onTapAddImage() Callback Method
     */
    override fun onTapAddImage() {
        mView.openGallery()
    }
}