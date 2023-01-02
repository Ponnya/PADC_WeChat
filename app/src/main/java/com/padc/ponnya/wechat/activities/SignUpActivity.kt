package com.padc.ponnya.wechat.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.padc.ponnya.wechat.databinding.ActivitySignUpBinding
import com.padc.ponnya.wechat.mvp.presenters.SignUpPresenter
import com.padc.ponnya.wechat.mvp.presenters.impl.SignUpPresenterImpl
import com.padc.ponnya.wechat.mvp.views.SignUpView
import com.padc.ponnya.wechat.utils.GENDER_KEY_FEMALE
import com.padc.ponnya.wechat.utils.GENDER_KEY_MALE
import com.padc.ponnya.wechat.utils.GENDER_KEY_OTHER
import com.padc.ponnya.wechat.utils.MONTHS
import java.util.*

class SignUpActivity : BaseAbstractActivity(), SignUpView {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var mPresenter: SignUpPresenter
    private lateinit var mPhone: String
    private var mGender = -1L
    private var selectedYear: Int = 1900
    private var selectedMonth: Int = 0

    companion object {
        private const val EXTRA_PHONE = "EXTRA_PHONE"
        fun newIntent(context: Context, phone: String) = Intent(context, SignUpActivity::class.java)
            .putExtra(EXTRA_PHONE, phone)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mPresenter = getPresenter<SignUpPresenterImpl, SignUpView>()
        mPhone = intent.getStringExtra(EXTRA_PHONE) ?: ""
        setUpListener()
        setUpDropDown()

        mPresenter.onUiReady(this)
    }

    private fun setUpListener() {
        binding.btnBackSignUp.setOnClickListener {
            mPresenter.onTapBack()
        }

        with(binding) {
            btnSignUp2.setOnClickListener {
                mPresenter.onTapSignUp(
                    phone = mPhone,
                    name = edtName.text.toString(),
                    day = autoCompleteTextViewDay.text.toString(),
                    month = autoCompleteTextViewMonth.text.toString(),
                    year = autoCompleteTextViewYear.text.toString(),
                    gender = mGender,
                    password = edtSignUpPassword.text.toString(),
                    termAndService = checkBoxTermAndService.isChecked
                )
            }
        }

        binding.radioGroupGender.setOnCheckedChangeListener { _, i ->
            when (i) {
                binding.radioBtnMale.id -> {
                    mGender = GENDER_KEY_MALE
                }
                binding.radioBtnFemale.id -> {
                    mGender = GENDER_KEY_FEMALE
                }
                binding.radioBtnOther.id -> {
                    mGender = GENDER_KEY_OTHER
                }
            }
        }
    }

    private fun setUpDropDown() {
        setUpDay()
        setUpMonth()
        setUpYear()
    }

    private fun setUpYear() {
        val thisYear = Calendar.getInstance().get(Calendar.YEAR)
        val yearList = (1900..thisYear).toList()
        val yearAdapter = ArrayAdapter(
            this, android.R.layout.simple_spinner_dropdown_item, yearList
        )
        binding.autoCompleteTextViewYear.setAdapter(yearAdapter)
        binding.autoCompleteTextViewYear.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, _, _ ->
                selectedYear = binding.autoCompleteTextViewYear.text.toString().toInt()
                binding.autoCompleteTextViewMonth.text = null
                setUpDay()
            }
    }

    private fun setUpMonth() {
        val monthAdapter = ArrayAdapter(
            this, android.R.layout.simple_spinner_dropdown_item, MONTHS
        )
        binding.autoCompleteTextViewMonth.setAdapter(monthAdapter)
        binding.autoCompleteTextViewMonth.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, _, _ ->
                selectedMonth = MONTHS.indexOf(binding.autoCompleteTextViewMonth.text.toString())
                setUpDay()
            }
    }

    private fun setUpDay() {
        val lengthOfMonth: Int
        with(Calendar.getInstance()) {
            set(Calendar.YEAR, selectedYear)
            set(Calendar.MONTH, selectedMonth)
            lengthOfMonth = getActualMaximum(Calendar.DATE)
        }
        val dayList = (1..lengthOfMonth).toList()
        val dayAdapter = ArrayAdapter(
            this, android.R.layout.simple_spinner_dropdown_item, dayList
        )
        binding.autoCompleteTextViewDay.setAdapter(dayAdapter)
        binding.autoCompleteTextViewDay.text = null
    }

    override fun navigateToHomeScreen() {
        startActivity(HomeActivity.newIntent(this))
        finish()
    }

    override fun showNameError(error: String) {
        binding.edtName.error = error
    }

    override fun showDayError(error: String) {
        binding.autoCompleteTextViewDay.error = error
    }

    override fun showMonthError(error: String) {
        binding.autoCompleteTextViewMonth.error = error
    }

    override fun showYearError(error: String) {
        binding.autoCompleteTextViewYear.error = error
    }

    override fun showPasswordError(error: String) {
        binding.edtSignUpPassword.error = error
    }

    override fun showTermAndServiceError(error: String) {
        binding.checkBoxTermAndService.error = error
    }


    override fun navigateToVerifyScreen() {
        finish()
    }
}