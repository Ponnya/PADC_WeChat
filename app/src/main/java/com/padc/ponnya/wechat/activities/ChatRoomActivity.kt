package com.padc.ponnya.wechat.activities

import android.os.Bundle
import com.padc.ponnya.wechat.databinding.ActivityChatRoomBinding

class ChatRoomActivity : BaseAbstractActivity() {
    private lateinit var binding: ActivityChatRoomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}