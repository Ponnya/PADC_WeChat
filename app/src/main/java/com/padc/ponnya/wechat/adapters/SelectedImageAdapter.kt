package com.padc.ponnya.wechat.adapters

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.ViewGroup
import com.padc.ponnya.wechat.databinding.ViewholderSelectedImageBinding
import com.padc.ponnya.wechat.delegates.SelectedImageDelegate
import com.padc.ponnya.wechat.viewholders.SelectedImageViewHolder

class SelectedImageAdapter(private val mDelegate: SelectedImageDelegate) :
    BaseAbstractAdapter<SelectedImageViewHolder, Bitmap>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectedImageViewHolder {
        val view = ViewholderSelectedImageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SelectedImageViewHolder(mDelegate, view)
    }

    override fun onBindViewHolder(holder: SelectedImageViewHolder, position: Int) {
        if (position == mData.size || mData.size == 0) {
            holder.setAddSign()
        } else {
            holder.bindData(mData[position])
        }
    }

    override fun getItemCount(): Int = mData.size + 1
}