package com.padc.ponnya.wechat.viewholders

import com.bumptech.glide.Glide
import com.padc.ponnya.wechat.data.vos.UserVO
import com.padc.ponnya.wechat.databinding.ViewholderChatItemBinding
import com.padc.ponnya.wechat.delegates.ChatListDelegate
import com.padc.ponnya.wechat.utils.toDuration
import java.util.*

class ChatItemViewHolder(
    private val mDelegate: ChatListDelegate,
    private val binding: ViewholderChatItemBinding,
) :
    BaseAbstractViewHolder<UserVO>(binding) {
    init {
        binding.root.setOnClickListener {
            mData?.userId?.let { receiver ->
                mDelegate.onTapChat(receiver,
                    mData!!.name,
                    mData!!.profilePic)
            }
        }
    }

    override fun bindData(data: UserVO) {
        mData = data
        if (data.profilePic.isNotBlank()) {
            Glide.with(binding.root)
                .load(data.profilePic)
                .into(binding.imgProfile)
        }

        binding.txtChatName.text = data.name
        binding.tvSentBy.text = if (data.sentBy == data.userId) "${data.name} : " else "You : "
        binding.tvLatestMessage.text = data.lastMessage
        binding.txtLastChatDateTime.text =
            (Calendar.getInstance().time.time - data.lastMessageSentTime).toDuration()
    }
}