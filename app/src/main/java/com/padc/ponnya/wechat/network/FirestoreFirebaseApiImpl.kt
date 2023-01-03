package com.padc.ponnya.wechat.network

import com.padc.ponnya.wechat.utils.*

object FirestoreFirebaseApiImpl : FirebaseApi {
    override fun login(
        phone: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
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
        onFailure: (String) -> Unit
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
}