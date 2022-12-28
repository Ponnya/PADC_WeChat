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
import com.padc.ponnya.wechat.utils.MONTHS
import java.util.*

class SignUpActivity : BaseAbstractActivity(), SignUpView {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var mPresenter: SignUpPresenter
    private var selectedYear: Int = 1900
    private var selectedMonth: Int = 0

    companion object {
        fun newIntent(context: Context) = Intent(context, SignUpActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mPresenter = getPresenter<SignUpPresenterImpl, SignUpView>()

        setUpListener()
        setUpDropDown()

        mPresenter.onUiReady(this)
    }

    private fun setUpListener() {
        binding.btnBackSignUp.setOnClickListener {
            mPresenter.onTapBack()
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
            AdapterView.OnItemClickListener { parent, view, position, id ->
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
            AdapterView.OnItemClickListener { parent, view, position, id ->
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

    override fun navigateToVerifyScreen() {
        finish()
    }
}