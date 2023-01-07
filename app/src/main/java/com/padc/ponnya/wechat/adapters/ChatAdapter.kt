package com.padc.ponnya.wechat.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padc.ponnya.wechat.data.vos.UserVO
import com.padc.ponnya.wechat.databinding.ViewholderChatBinding
import com.padc.ponnya.wechat.viewholders.ChatViewHolder

class ChatAdapter : BaseAbstractAdapter<ChatViewHolder, UserVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = ViewholderChatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChatViewHolder(view)
    }
}