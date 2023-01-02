package com.padc.ponnya.wechat.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padc.ponnya.wechat.data.vos.MomentImageVO
import com.padc.ponnya.wechat.databinding.ViewholderSelectedImageBinding
import com.padc.ponnya.wechat.utils.ADD_SIGN
import com.padc.ponnya.wechat.viewholders.SelectedImageViewHolder

class SelectedImageAdapter : BaseAbstractAdapter<SelectedImageViewHolder, MomentImageVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectedImageViewHolder {
        val view = ViewholderSelectedImageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SelectedImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: SelectedImageViewHolder, position: Int) {
        if (position == mData.size || mData.size == 0) {
            holder.bindData(MomentImageVO(ADD_SIGN))
        } else {
            holder.bindData(mData[position])
        }
    }

    override fun getItemCount(): Int = mData.size + 1
}