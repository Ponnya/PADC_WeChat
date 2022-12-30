package com.padc.ponnya.wechat.viewholders

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseAbstractViewHolder<W>(binding: ViewBinding) :
    RecyclerView.ViewHolder(binding.root) {
    protected var mData: W? = null
    abstract fun bindData(data: W)
}