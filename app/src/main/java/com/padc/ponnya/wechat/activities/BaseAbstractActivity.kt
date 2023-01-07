package com.padc.ponnya.wechat.activities


import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.padc.ponnya.wechat.mvp.presenters.AbstractBasePresenter
import com.padc.ponnya.wechat.mvp.views.BaseView

abstract class BaseAbstractActivity : AppCompatActivity(), BaseView {
    inline fun <reified T : AbstractBasePresenter<V>, reified V : BaseView> getPresenter(): T {
        val presenter = ViewModelProvider(this)[T::class.java]
        if (this is V) presenter.initView(this)
        return presenter
    }

    override fun showError(error: String) {
        Snackbar.make(window.decorView, error, Snackbar.LENGTH_LONG).show()
    }

    fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }

}