package com.padc.ponnya.wechat.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padc.ponnya.wechat.data.vos.UserVO
import com.padc.ponnya.wechat.databinding.ViewholderChatItemBinding
import com.padc.ponnya.wechat.delegates.ChatListDelegate
import com.padc.ponnya.wechat.viewholders.ChatItemViewHolder

class ChatItemAdapter(private val mDelegate: ChatListDelegate) :
    BaseAbstractAdapter<ChatItemViewHolder, UserVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatItemViewHolder {
        val view =
            ViewholderChatItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChatItemViewHolder(mDelegate, view)
    }
}