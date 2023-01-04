package com.padc.ponnya.wechat.viewholders

import com.bumptech.glide.Glide
import com.padc.ponnya.wechat.R
import com.padc.ponnya.wechat.databinding.ViewholderMomentImageBinding

class MomentImageViewHolder(private val binding: ViewholderMomentImageBinding) :
    BaseAbstractViewHolder<String>(binding) {
    override fun bindData(data: String) {
        Glide.with(binding.root.context)
            .load(data)
            .placeholder(R.color.black)
            .into(binding.ivMomentImage)
    }
}