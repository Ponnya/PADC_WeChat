package com.padc.ponnya.wechat.data.models

import android.graphics.Bitmap
import com.padc.ponnya.wechat.data.vos.MomentVO
import com.padc.ponnya.wechat.network.FirebaseApi
import com.padc.ponnya.wechat.network.FirestoreFirebaseApiImpl

interface WeChatModel {
    val mFirebaseApi: FirebaseApi
        get() = FirestoreFirebaseApiImpl

    fun login(phone: String, password: String, onSuccess: () -> Unit, onFailure: (String) -> Unit)

    fun register(
        phone: String,
        name: String,
        dob: String,
        gender: Long,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit,
    )

    fun createMoment(
        text: String,
        imageList: List<Bitmap>,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit,
    )

    fun getMoments(onSuccess: (List<MomentVO>) -> Unit, onFailure: (String) -> Unit)

    fun likeCountIncreaseOrDecrease(
        postedPhone: String,
        postedTime: String,
        onFailure: (String) -> Unit,
    )

}