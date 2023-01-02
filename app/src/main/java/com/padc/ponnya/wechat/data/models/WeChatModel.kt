package com.padc.ponnya.wechat.data.models

import com.padc.ponnya.wechat.network.FirebaseApi
import com.padc.ponnya.wechat.network.FirestoreFirebaseApiImpl

interface WeChatModel {
    val mFirebaseApi: FirebaseApi
        get() = FirestoreFirebaseApiImpl

    fun register(
        phone: String,
        name: String,
        dob: String,
        gender: Long,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    )
}