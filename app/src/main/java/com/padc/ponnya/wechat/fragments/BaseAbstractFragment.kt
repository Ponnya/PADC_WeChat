package com.padc.ponnya.wechat.fragments

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.padc.ponnya.wechat.mvp.presenters.AbstractBasePresenter
import com.padc.ponnya.wechat.mvp.views.BaseView

abstract class BaseAbstractFragment : Fragment(), BaseView {
    inline fun <reified T : AbstractBasePresenter<V>, reified V : BaseView> getPresenter(): T {
        val presenter = ViewModelProvider(this)[T::class.java]
        if (this is V) presenter.initView(this)
        return presenter
    }

    override fun showError(error: String) {
        view?.let { Snackbar.make(it, error, Snackbar.LENGTH_LONG).show() }
    }
}