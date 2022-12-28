package com.padc.ponnya.wechat.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.padc.ponnya.wechat.databinding.ActivityLoginBinding
import com.padc.ponnya.wechat.mvp.presenters.LoginPresenter
import com.padc.ponnya.wechat.mvp.presenters.impl.LoginPresenterImpl
import com.padc.ponnya.wechat.mvp.views.LoginView

class LoginActivity : BaseAbstractActivity(), LoginView {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var mPresenter: LoginPresenter

    companion object {
        fun newIntent(context: Context) = Intent(context, LoginActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mPresenter = getPresenter<LoginPresenterImpl, LoginView>()
        setUpListener()

        mPresenter.onUiReady(this)
    }

    private fun setUpListener() {
        binding.btnBackLogin.setOnClickListener {
            mPresenter.onTapBack()
        }
    }

    override fun navigateToWelcome() {
        finish()
    }
}