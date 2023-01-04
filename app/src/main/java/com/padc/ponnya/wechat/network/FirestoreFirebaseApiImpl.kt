package com.padc.ponnya.wechat.network

import android.graphics.Bitmap
import com.padc.ponnya.wechat.data.vos.MomentVO
import com.padc.ponnya.wechat.utils.*
import java.io.ByteArrayOutputStream
import java.util.*

object FirestoreFirebaseApiImpl : FirebaseApi {
    override fun login(
        phone: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit,
    ) {
        database.collection(COLLECTION_ACCOUNT)
            .whereEqualTo(FIELD_PHONE, phone)
            .whereEqualTo(FIELD_PASSWORD, password)
            .get()
            .addOnSuccessListener {
                if (it.documents.isNotEmpty()) onSuccess()
                else onFailure(ERROR_INVALID_PHONE_NUMBER_AND_PASSWORD)
            }
            .addOnFailureListener { onFailure(it.localizedMessage ?: ERROR_CHECK_INTERNET) }
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
        val accountMap = hashMapOf(
            FIELD_PHONE to phone,
            FIELD_NAME to name,
            FIELD_DOB to dob,
            FIELD_GENDER to gender,
            FIELD_PASSWORD to password,
        )
        database.collection(COLLECTION_ACCOUNT)
            .document(phone)
            .set(accountMap)
            .addOnSuccessListener {
                onSuccess()
            }
            .addOnFailureListener {
                onFailure(it.localizedMessage ?: ERROR_CHECK_INTERNET)
            }

    }

    override fun createMoment(
        phone: String,
        text: String,
        imageList: List<Bitmap>,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit,
    ) {

        val postedTime = Calendar.getInstance().time.time

        val momentMap = hashMapOf(
            FIELD_TEXT to text,
            FIELD_LIKE_COUNT to 0L,
            FIELD_COMMENT_COUNT to 0L,
            FIELD_POSTED_TIME to postedTime
        )
        database.collection(COLLECTION_ACCOUNT)
            .document(phone)
            .collection(COLLECTION_MOMENT)
            .document(postedTime.toString())
            .set(momentMap)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { onFailure(it.localizedMessage ?: ERROR_CHECK_INTERNET) }

        val imageDownloadUrlList = arrayListOf<String>()
        imageList.forEach { imageBitmap ->
            val baos = ByteArrayOutputStream()
            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
            val data = baos.toByteArray()
            val imageRef = storage.reference.child("images/${UUID.randomUUID()}")
            imageRef.putBytes(data)
                .continueWithTask {
                    return@continueWithTask imageRef.downloadUrl
                }.addOnCompleteListener {
                    val imageUrl = it.result?.toString()
                    imageUrl?.let { url -> imageDownloadUrlList.add(url) }
                    database.collection(COLLECTION_ACCOUNT)
                        .document(phone)
                        .collection(COLLECTION_MOMENT)
                        .document(postedTime.toString())
                        .update(FIELD_IMAGES, imageDownloadUrlList)
                }
        }


    }

    override fun getMoments(
        phone: String,
        onSuccess: (List<MomentVO>) -> Unit,
        onFailure: (String) -> Unit,
    ) {
        database.collection(COLLECTION_ACCOUNT)
            .document(phone)
            .collection(COLLECTION_MOMENT)
            .addSnapshotListener { value, error ->
                error?.let { onFailure(it.localizedMessage ?: ERROR_CHECK_INTERNET) } ?: run {
                    val momentList = arrayListOf<MomentVO>()
                    val result = value?.documents ?: listOf()
                    for (document in result) {
                        println(document)
                        val data = document.data ?: mapOf()
                        val moment = MomentVO(
                            text = data[FIELD_TEXT] as String?,
                            images = data[FIELD_IMAGES] as List<String>?,
                            likeCount = (data[FIELD_LIKE_COUNT] as Long?)?.toInt(),
                            commentCount = (data[FIELD_COMMENT_COUNT] as Long?)?.toInt(),
                            postedTime = data[FIELD_POSTED_TIME] as Long?,

                            )
                        momentList.add(moment)
                    }
                    onSuccess(momentList)
                }
            }
    }
}