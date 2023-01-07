package com.padc.ponnya.wechat.network

import android.graphics.Bitmap
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.padc.ponnya.wechat.data.vos.MomentVO
import com.padc.ponnya.wechat.data.vos.UserVO

interface FirebaseApi {
    val realTimeDb: DatabaseReference
        get() = Firebase.database.reference
    val firestoreDb: FirebaseFirestore
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

    fun getChatMessage(
        sender: String,
        receiver: String,
        onSuccess: (List<UserVO>) -> Unit,
        onFailure: (String) -> Unit,
    )

    fun getChatList(sender: String, onSuccess: (List<UserVO>) -> Unit, onFailure: (String) -> Unit)
}