package com.padc.ponnya.wechat.data.models

import android.graphics.Bitmap
import com.padc.ponnya.wechat.data.vos.MomentVO

object WeChatModelImpl : WeChatModel {
    private lateinit var mPhone: String
    override fun login(
        phone: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit,
    ) {
        mPhone = phone
        mFirebaseApi.login(phone, password, onSuccess, onFailure)
    }

    override fun register(
        phone: String,
        name: String,
        dob: String,
        gender: Long,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit,
    ) {
        mPhone = phone
        mFirebaseApi.register(phone, name, dob, gender, password, onSuccess, onFailure)
    }

    override fun createMoment(
        text: String,
        imageList: List<Bitmap>,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit,
    ) {
        mFirebaseApi.createMoment(mPhone, text, imageList, onSuccess, onFailure)
    }

    override fun getMoments(
        onSuccess: (List<MomentVO>) -> Unit,
        onFailure: (String) -> Unit,
    ) {
        mFirebaseApi.getMoments(mPhone, onSuccess, onFailure)
    }

    override fun likeCountIncreaseOrDecrease(
        postedPhone: String,
        postedTime: String,
        onFailure: (String) -> Unit,
    ) {
        mFirebaseApi.likeCountIncreaseOrDecrease(mPhone, postedPhone, postedTime, onFailure)
    }

}