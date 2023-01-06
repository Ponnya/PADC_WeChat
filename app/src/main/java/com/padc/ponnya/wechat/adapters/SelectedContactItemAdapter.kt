package com.padc.ponnya.wechat.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padc.ponnya.wechat.data.vos.UserVO
import com.padc.ponnya.wechat.databinding.ViewholderSelectedContactItemBinding
import com.padc.ponnya.wechat.viewholders.SelectedContactItemViewHolder

class SelectedContactItemAdapter : BaseAbstractAdapter<SelectedContactItemViewHolder, UserVO>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): SelectedContactItemViewHolder {
        val view = ViewholderSelectedContactItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false)
        return SelectedContactItemViewHolder(view)
    }
}