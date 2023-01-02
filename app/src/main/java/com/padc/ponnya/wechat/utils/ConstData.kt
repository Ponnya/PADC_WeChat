package com.padc.ponnya.wechat.utils

val MONTHS = arrayListOf(
    "Jan", "Feb",
    "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept",
    "Oct", "Nov", "Dec"
)

const val OTP = "2240"

const val GENDER_KEY_MALE = 1
const val GENDER_KEY_FEMALE = 2
const val GENDER_KEY_OTHER = 3

const val GENDER_VALUE_MALE = "Male"
const val GENDER_VALUE_FEMALE = "Female"
const val GENDER_VALUE_OTHER = "Other"

val GENDER_MAP = mapOf(
    GENDER_KEY_MALE to GENDER_VALUE_MALE,
    GENDER_KEY_FEMALE to GENDER_VALUE_FEMALE,
    GENDER_KEY_OTHER to GENDER_VALUE_OTHER
)

const val ADD_SIGN = "ADD_SIGN"

const val TITLE_MOMENT = "Moment"
const val TITLE_CHAT = "Chat"
const val TITLE_CONTACTS = "Contacts"
const val TITLE_ME = "Me"

const val COLLECTION_ACCOUNT = "Account"
const val FIELD_NAME = "Name"
const val FIELD_PHONE = "Phone"
const val FIELD_DOB = "DOB"
const val FIELD_GENDER = "Gender"
const val FIELD_PASSWORD = "Password"

const val ERROR_CHECK_INTERNET = "Please check internet connection"
const val ERROR_INVALID_OTP = "OTP is invalid"
