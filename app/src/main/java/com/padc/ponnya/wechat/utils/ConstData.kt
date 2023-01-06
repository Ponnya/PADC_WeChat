package com.padc.ponnya.wechat.utils

val MONTHS = arrayListOf(
    "Jan", "Feb",
    "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept",
    "Oct", "Nov", "Dec"
)

const val OTP = "2240"

const val INTENT_TYPE_IMAGE = "image/*"

const val GENDER_KEY_MALE = 0L
const val GENDER_KEY_FEMALE = 1L
const val GENDER_KEY_OTHER = 2L

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

//Firestore Database
const val COLLECTION_ACCOUNT = "Account"
const val COLLECTION_MOMENT = "Moment"
const val COLLECTION_LIKE = "Like_List"

const val FIELD_NAME = "Name"
const val FIELD_PHONE = "Phone"
const val FIELD_DOB = "DOB"
const val FIELD_GENDER = "Gender"
const val FIELD_PASSWORD = "Password"

const val FIELD_TEXT = "Text"
const val FIELD_IMAGES = "Images"
const val FIELD_LIKE_COUNT = "Like_Count"
const val FIELD_COMMENT_COUNT = "Comment_Count"
const val FIELD_POSTED_TIME = "Posted_Time"

//Realtime Database
const val FIELD_MESSAGES = "Messages"
const val FIELD_FILE = "file"
const val FIELD_MESSAGE = "message"
const val FIELD_PROFILE_PIC = "profilePic"
const val FIELD_TIMESTAMP = "timestamp"
const val FIELD_USER_ID = "userId"

const val ERROR_CHECK_INTERNET = "Please check internet connection"
const val ERROR_INVALID_OTP = "OTP is invalid"
const val ERROR_INVALID_PHONE = "Phone is invalid"
const val ERROR_INVALID_NAME = "Please enter name"
const val ERROR_INVALID_DAY = "Please choose day"
const val ERROR_INVALID_MONTH = "Please choose month"
const val ERROR_INVALID_YEAR = "Please choose year"
const val ERROR_INVALID_GENDER = "Please choose gender"
const val ERROR_INVALID_PASSWORD = "Please enter password"
const val ERROR_INVALID_TERM_AND_SERVICE = "Please agree to term and service"
const val ERROR_INVALID_PHONE_NUMBER_AND_PASSWORD = "Invalid phone number and password"
