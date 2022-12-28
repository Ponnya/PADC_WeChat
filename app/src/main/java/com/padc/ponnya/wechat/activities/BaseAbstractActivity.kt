package com.padc.ponnya.wechat.activities


import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.padc.ponnya.wechat.mvp.presenters.AbstractBasePresenter
import com.padc.ponnya.wechat.mvp.views.BaseView

abstract class BaseAbstractActivity : AppCompatActivity() {
    inline fun <reified T : AbstractBasePresenter<V>, reified V : BaseView> getPresenter(): T {
        val presenter = ViewModelProvider(this)[T::class.java]
        if (this is V) presenter.initView(this)
        return presenter
    }
}