package com.padc.ponnya.wechat.data.models

import android.graphics.Bitmap
import com.padc.ponnya.wechat.data.vos.MomentVO
import com.padc.ponnya.wechat.data.vos.UserVO
import com.padc.ponnya.wechat.network.FirebaseApi
import com.padc.ponnya.wechat.network.FirebaseApiImpl

interface WeChatModel {
    val mFirebaseApi: FirebaseApi
        get() = FirebaseApiImpl

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

    fun getChatMessage(
        receiver: String,
        onSuccess: (List<UserVO>) -> Unit,
        onFailure: (String) -> Unit,
    )

    fun getChatList(onSuccess: (List<UserVO>) -> Unit, onFailure: (String) -> Unit)

    fun insertMessage(
        receiver: String,
        message: String,
        file: String,
        name: String,
        profilePic: String,
    )

}