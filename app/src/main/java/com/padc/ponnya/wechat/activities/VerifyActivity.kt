package com.padc.ponnya.wechat.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.padc.ponnya.wechat.databinding.ActivityVerifyBinding
import com.padc.ponnya.wechat.mvp.presenters.VerifyPresenter
import com.padc.ponnya.wechat.mvp.presenters.impl.VerifyPresenterImpl
import com.padc.ponnya.wechat.mvp.views.VerifyView
import com.padc.ponnya.wechat.utils.GenericKeyEvent
import com.padc.ponnya.wechat.utils.GenericTextWatcher

class VerifyActivity : BaseAbstractActivity(), VerifyView {
    private lateinit var binding: ActivityVerifyBinding
    private lateinit var mPresenter: VerifyPresenter

    companion object {
        fun newIntent(context: Context) = Intent(context, VerifyActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerifyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mPresenter = getPresenter<VerifyPresenterImpl, VerifyView>()

        setUpOTP()
        setUpListener()
        mPresenter.onUiReady(this)
    }

    private fun setUpOTP() {
        //GenericTextWatcher here works only for moving to next EditText when a number is entered
        //first parameter is the current EditText and second parameter is next EditText
        binding.edtOTP1.addTextChangedListener(GenericTextWatcher(binding.edtOTP1, binding.edtOTP2))
        binding.edtOTP2.addTextChangedListener(GenericTextWatcher(binding.edtOTP2, binding.edtOTP3))
        binding.edtOTP3.addTextChangedListener(GenericTextWatcher(binding.edtOTP3, binding.edtOTP4))
        binding.edtOTP4.addTextChangedListener(GenericTextWatcher(binding.edtOTP4, null))

        //GenericKeyEvent here works for deleting the element and to switch back to previous EditText
        //first parameter is the current EditText and second parameter is previous EditText
        binding.edtOTP1.setOnKeyListener(GenericKeyEvent(binding.edtOTP1, null))
        binding.edtOTP2.setOnKeyListener(GenericKeyEvent(binding.edtOTP2, binding.edtOTP1))
        binding.edtOTP3.setOnKeyListener(GenericKeyEvent(binding.edtOTP3, binding.edtOTP2))
        binding.edtOTP4.setOnKeyListener(GenericKeyEvent(binding.edtOTP4, binding.edtOTP3))
    }

    private fun setUpListener() {
        //VerifyBtn
        binding.btnVerify.setOnClickListener {
            mPresenter.onTapVerify()
        }

        //BackBtn
        binding.btnBackVerify.setOnClickListener {
            mPresenter.onTapBack()
        }
    }

    override fun navigateToSignUp() {
        startActivity(SignUpActivity.newIntent(this))
    }

    override fun navigateToWelcomeScreen() {
        finish()
    }
}

