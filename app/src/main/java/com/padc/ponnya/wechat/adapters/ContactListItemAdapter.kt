package com.padc.ponnya.wechat.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padc.ponnya.wechat.data.vos.UserVO
import com.padc.ponnya.wechat.databinding.ViewholderContactListItemBinding
import com.padc.ponnya.wechat.viewholders.ContactListItemViewHolder

class ContactListItemAdapter : BaseAbstractAdapter<ContactListItemViewHolder, UserVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactListItemViewHolder {
        val view = ViewholderContactListItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false)
        return ContactListItemViewHolder(view)
    }
}