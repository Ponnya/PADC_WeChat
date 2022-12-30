package com.padc.ponnya.wechat.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padc.ponnya.wechat.data.vos.MomentImageVO
import com.padc.ponnya.wechat.databinding.ViewholderMomentImageBinding
import com.padc.ponnya.wechat.viewholders.MomentImageViewHolder

class MomentImageAdapter : BaseAbstractAdapter<MomentImageViewHolder, MomentImageVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MomentImageViewHolder {
        val view =
            ViewholderMomentImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MomentImageViewHolder(view)
    }


}