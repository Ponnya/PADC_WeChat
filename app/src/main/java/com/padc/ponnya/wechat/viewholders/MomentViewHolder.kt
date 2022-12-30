package com.padc.ponnya.wechat.viewholders

import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.padc.ponnya.wechat.adapters.MomentImageAdapter
import com.padc.ponnya.wechat.data.vos.MomentImageVO
import com.padc.ponnya.wechat.databinding.ViewholderMomentBinding

class MomentViewHolder(private val binding: ViewholderMomentBinding) :
    BaseAbstractViewHolder<MomentImageVO>(binding) {
    override fun bindData(data: MomentImageVO) {
        val momentImageAdapter = MomentImageAdapter()
        with(binding.rvMomentImage) {

            adapter = momentImageAdapter
            layoutManager =
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL).apply {
                    gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS
                }

        }
        val list = arrayListOf<MomentImageVO>()
        list.add(MomentImageVO("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2V0ObUf9YwERGDfSiSLLdkwkXD91vMUwSBA&usqp=CAU"))
        list.add(MomentImageVO("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRS0-nEMJ7_i6B50BIkN03s1lVT82y_DEDsKA&usqp=CAU"))
        list.add(MomentImageVO("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFBXXILAje0QDVqybBe_tjXz83A1spN9GcSA&usqp=CAU"))
        list.add(MomentImageVO("https://i.stack.imgur.com/Bpdap.jpg?s=328&g=1"))
        list.add(MomentImageVO("https://i.stack.imgur.com/73QY4.jpg"))
        list.add(MomentImageVO("https://i.stack.imgur.com/Bpdap.jpg?s=328&g=1"))
        momentImageAdapter.setNewData(list)
    }
}