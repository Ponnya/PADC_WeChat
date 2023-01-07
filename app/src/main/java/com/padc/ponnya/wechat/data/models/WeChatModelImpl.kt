package com.padc.ponnya.wechat.data.models

import android.graphics.Bitmap
import com.padc.ponnya.wechat.data.vos.MomentVO
import com.padc.ponnya.wechat.data.vos.UserVO
import java.util.*

object WeChatModelImpl : WeChatModel {
    private lateinit var mPhone: String
    private lateinit var mName: String
    private lateinit var mProfilePic: String
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

    override fun getChatMessage(
        receiver: String,
        onSuccess: (List<UserVO>) -> Unit,
        onFailure: (String) -> Unit,
    ) {
        mFirebaseApi.getChatMessage(
            sender = mPhone,
            receiver = receiver,
            onSuccess = {
                mName = it.find { userVO -> mPhone == userVO.userId }?.name ?: ""
                mProfilePic = it.find { userVO -> mPhone == userVO.userId }?.profilePic ?: ""
                val currentTime = Calendar.getInstance().time.time
                val messageList = it.map { userVO ->
                    userVO.copy(
                        duration = userVO.timestamp.let { time -> return@let currentTime - time },
                        isSender = mPhone == userVO.userId
                    )
                }
                onSuccess(messageList)
            },
            onFailure = onFailure)
    }

    override fun getChatList(
        onSuccess: (List<UserVO>) -> Unit,
        onFailure: (String) -> Unit,
    ) {
        mFirebaseApi.getChatList(mPhone, onSuccess, onFailure)
    }

    override fun insertMessage(
        receiver: String,
        message: String,
        file: String,
    ) {
        mFirebaseApi.insertMessage(mPhone, receiver, message, file, mName, mProfilePic)
    }

}