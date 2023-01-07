package com.padc.ponnya.wechat.viewholders

import android.view.Gravity
import android.view.View
import com.bumptech.glide.Glide
import com.padc.ponnya.wechat.R
import com.padc.ponnya.wechat.data.vos.UserVO
import com.padc.ponnya.wechat.databinding.ViewholderChatBinding
import com.padc.ponnya.wechat.utils.toDuration

class ChatViewHolder(private val binding: ViewholderChatBinding) :
    BaseAbstractViewHolder<UserVO>(binding) {
    override fun bindData(data: UserVO) {
        if (data.isSender) {
            binding.root.gravity = Gravity.RIGHT
            binding.ivUserProfile.visibility = View.GONE

        } else {
            with(data.profilePic) {
                if (isNotBlank())
                    Glide.with(binding.root)
                        .load(this)
                        .placeholder(R.color.black)
                        .into(binding.ivUserProfile)
            }
        }


        if (data.message.isNotBlank()) {
            binding.cardViewText.visibility = View.VISIBLE
            binding.tvChatText.text = data.message
            binding.tvChatSentTime.text = data.duration.toDuration()

        }

        if (data.file.isNotBlank()) {
            binding.rlMessageImage.visibility = View.VISIBLE
            Glide.with(binding.root)
                .load(data.file)
                .placeholder(R.color.black)
                .into(binding.ivChatImage)

            binding.tvChatSentTimeImage.text = data.duration.toDuration()

        }
    }
}