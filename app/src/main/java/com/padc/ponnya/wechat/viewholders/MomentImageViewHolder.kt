package com.padc.ponnya.wechat.viewholders

import com.bumptech.glide.Glide
import com.padc.ponnya.wechat.R
import com.padc.ponnya.wechat.data.vos.MomentImageVO
import com.padc.ponnya.wechat.databinding.ViewholderMomentImageBinding

class MomentImageViewHolder(private val binding: ViewholderMomentImageBinding) :
    BaseAbstractViewHolder<MomentImageVO>(binding) {
    override fun bindData(data: MomentImageVO) {
        Glide.with(binding.root.context)
            .load(data.dummy)
            .placeholder(R.color.black)
            .into(binding.ivMomentImage)
    }
}