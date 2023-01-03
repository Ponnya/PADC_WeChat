package com.padc.ponnya.wechat.data.models

import android.graphics.Bitmap

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
}