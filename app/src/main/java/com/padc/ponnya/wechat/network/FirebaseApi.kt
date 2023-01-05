package com.padc.ponnya.wechat.network

import android.graphics.Bitmap
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.padc.ponnya.wechat.data.vos.MomentVO

interface FirebaseApi {
    val database: FirebaseFirestore
        get() = Firebase.firestore

    val storage: FirebaseStorage
        get() = FirebaseStorage.getInstance()

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
        phone: String,
        text: String,
        imageList: List<Bitmap>,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit,
    )

    fun getMoments(phone: String, onSuccess: (List<MomentVO>) -> Unit, onFailure: (String) -> Unit)

    fun likeCountIncreaseOrDecrease(
        phone: String,
        postedPhone: String,
        postedTime: String,
        onFailure: (String) -> Unit,
    )

    // fun isLikeCheck(postedTime: String, phone: String,onSuccess: (Boolean) -> Unit,onFailure: (String) -> Unit)
}