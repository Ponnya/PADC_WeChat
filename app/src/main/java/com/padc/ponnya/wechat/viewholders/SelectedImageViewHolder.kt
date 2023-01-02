package com.padc.ponnya.wechat.viewholders

import com.bumptech.glide.Glide
import com.padc.ponnya.wechat.R
import com.padc.ponnya.wechat.data.vos.MomentImageVO
import com.padc.ponnya.wechat.databinding.ViewholderSelectedImageBinding
import com.padc.ponnya.wechat.utils.ADD_SIGN

class SelectedImageViewHolder(private val binding: ViewholderSelectedImageBinding) :
    BaseAbstractViewHolder<MomentImageVO>(binding) {
    override fun bindData(data: MomentImageVO) {
        if (data.dummy == ADD_SIGN) {
            Glide.with(binding.root)
                .load(R.drawable.add_blue_24dp)
                .placeholder(R.color.colorPrimary)
                .into(binding.ivSelectedImage)
        } else {
            Glide.with(binding.root)
                .load(data.dummy)
                .placeholder(R.color.colorPrimary)
                .into(binding.ivSelectedImage)
        }

    }
}