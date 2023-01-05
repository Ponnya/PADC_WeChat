package com.padc.ponnya.wechat.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padc.ponnya.wechat.data.vos.MomentVO
import com.padc.ponnya.wechat.databinding.ViewholderMomentBinding
import com.padc.ponnya.wechat.delegates.MomentDelegate
import com.padc.ponnya.wechat.viewholders.MomentViewHolder

class MomentAdapter(private val mDelegate: MomentDelegate) :
    BaseAbstractAdapter<MomentViewHolder, MomentVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MomentViewHolder {
        val view =
            ViewholderMomentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MomentViewHolder(mDelegate, view)
    }


}