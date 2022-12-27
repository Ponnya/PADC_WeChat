package com.padc.ponnya.wechat.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.padc.ponnya.wechat.databinding.ActivityLoginBinding

class LoginActivity : BasicAbstractActivity() {
    private lateinit var binding: ActivityLoginBinding

    companion object {
        fun newIntent(context: Context) = Intent(context, LoginActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}