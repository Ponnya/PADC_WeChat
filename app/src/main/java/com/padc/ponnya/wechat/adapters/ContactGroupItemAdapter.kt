package com.padc.ponnya.wechat.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padc.ponnya.wechat.data.vos.UserVO
import com.padc.ponnya.wechat.databinding.ViewholderContactGroupItemBinding
import com.padc.ponnya.wechat.viewholders.ContactGroupItemViewHolder

class ContactGroupItemAdapter : BaseAbstractAdapter<ContactGroupItemViewHolder, UserVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactGroupItemViewHolder {
        val view = ViewholderContactGroupItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false)
        return ContactGroupItemViewHolder(view)
    }
}