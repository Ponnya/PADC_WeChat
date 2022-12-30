package com.padc.ponnya.wechat.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padc.ponnya.wechat.data.vos.MomentImageVO
import com.padc.ponnya.wechat.databinding.ViewholderMomentBinding
import com.padc.ponnya.wechat.viewholders.MomentViewHolder

class MomentAdapter : BaseAbstractAdapter<MomentViewHolder, MomentImageVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MomentViewHolder {
        val view =
            ViewholderMomentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MomentViewHolder(view)
    }

    override fun onBindViewHolder(holder: MomentViewHolder, position: Int) {
        holder.bindData(MomentImageVO("test"))
    }

    override fun getItemCount(): Int {
        return 2
    }
}