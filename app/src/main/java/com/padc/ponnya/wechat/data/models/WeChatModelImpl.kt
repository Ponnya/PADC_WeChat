package com.padc.ponnya.wechat.data.models

object WeChatModelImpl : WeChatModel {
    override fun login(
        phone: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.login(phone, password, onSuccess, onFailure)
    }

    override fun register(
        phone: String,
        name: String,
        dob: String,
        gender: Long,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.register(phone, name, dob, gender, password, onSuccess, onFailure)
    }
}