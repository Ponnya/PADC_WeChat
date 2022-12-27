package com.padc.ponnya.wechat.activities

import android.os.Bundle
import com.padc.ponnya.wechat.databinding.ActivityWelcomeBinding
import com.padc.ponnya.wechat.mvp.presenters.Impl.WelcomePresenterImpl
import com.padc.ponnya.wechat.mvp.presenters.WelcomePresenter
import com.padc.ponnya.wechat.mvp.views.WelcomeView

class WelcomeActivity : BasicAbstractActivity(), WelcomeView {
    private lateinit var binding: ActivityWelcomeBinding
    private lateinit var mPresenter: WelcomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mPresenter = getPresenter<WelcomePresenterImpl, WelcomeView>()
        setUpListeners()
        mPresenter.onUiReady(this)
    }

    private fun setUpListeners() {
        binding.btnWelcomeLogin.setOnClickListener {
            mPresenter.onTapLogin()
        }
    }

    override fun navigateToLogin() {
        startActivity(LoginActivity.newIntent(this))
    }
}