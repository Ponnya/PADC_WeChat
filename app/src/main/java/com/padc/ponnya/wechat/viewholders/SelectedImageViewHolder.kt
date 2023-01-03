package com.padc.ponnya.wechat.viewholders

import android.graphics.Bitmap
import com.bumptech.glide.Glide
import com.padc.ponnya.wechat.R
import com.padc.ponnya.wechat.databinding.ViewholderSelectedImageBinding
import com.padc.ponnya.wechat.delegates.SelectedImageDelegate

class SelectedImageViewHolder(
    private val mDelegate: SelectedImageDelegate,
    private val binding: ViewholderSelectedImageBinding,
) :
    BaseAbstractViewHolder<Bitmap>(binding) {

    private var isLastPics: Boolean = false

    init {
        binding.ivSelectedImage.setOnClickListener {
            if (isLastPics)
                mDelegate.onTapAddImage()
        }

    }

    override fun bindData(data: Bitmap) {
        isLastPics = false
        binding.ivSelectedImage.setImageBitmap(data)

    }

    fun setAddSign() {
        isLastPics = true
        Glide.with(binding.root)
            .load(R.drawable.add_blue_24dp)
            .placeholder(R.color.colorPrimary)
            .into(binding.ivSelectedImage)
    }
}