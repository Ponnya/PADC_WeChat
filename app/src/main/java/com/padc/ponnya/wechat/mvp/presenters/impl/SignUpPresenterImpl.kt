package com.padc.ponnya.wechat.mvp.presenters.impl

import androidx.lifecycle.LifecycleOwner
import com.padc.ponnya.wechat.mvp.presenters.AbstractBasePresenter
import com.padc.ponnya.wechat.mvp.presenters.SignUpPresenter
import com.padc.ponnya.wechat.mvp.views.SignUpView
import com.padc.ponnya.wechat.utils.*

class SignUpPresenterImpl : AbstractBasePresenter<SignUpView>(), SignUpPresenter {

    override fun onTapSignUp(
        phone: String,
        name: String,
        day: String,
        month: String,
        year: String,
        gender: Long,
        password: String,
        termAndService: Boolean
    ) {

        if (phone.isEmpty()) {
            mView.showError(ERROR_INVALID_PHONE)
        } else {
            if (name.isEmpty()) mView.showNameError(ERROR_INVALID_NAME)

            if (day.isEmpty()) mView.showDayError(ERROR_INVALID_DAY)

            if (month.isEmpty()) mView.showMonthError(ERROR_INVALID_MONTH)

            if (year.isEmpty()) mView.showYearError(ERROR_INVALID_YEAR)

            if (gender == -1L) mView.showError(ERROR_INVALID_GENDER)

            if (password.isEmpty()) mView.showPasswordError(ERROR_INVALID_PASSWORD)

            if (!termAndService) mView.showTermAndServiceError(ERROR_INVALID_TERM_AND_SERVICE)

            if (name.isNotEmpty() && day.isNotEmpty() && month.isNotEmpty() && year.isNotEmpty() && gender != -1L && password.isNotEmpty() && termAndService) {
                val dob = StringBuffer()
                    .append(day)
                    .append('/')
                    .append(MONTHS.indexOf(month) + 1)
                    .append('/')
                    .append(year).toString()
                mModel.register(
                    phone = phone,
                    name = name,
                    dob = dob,
                    gender = gender,
                    password = password,
                    onSuccess = {
                        mView.navigateToHomeScreen()
                    },
                    onFailure = {
                        mView.showError(it)
                    }
                )
            }
        }

    }

    override fun onTapBack() {
        mView.navigateToVerifyScreen()
    }

    override fun onUiReady(owner: LifecycleOwner) {

    }
}