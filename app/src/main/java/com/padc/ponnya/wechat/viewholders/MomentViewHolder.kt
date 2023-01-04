package com.padc.ponnya.wechat.viewholders

import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.padc.ponnya.wechat.adapters.MomentImageAdapter
import com.padc.ponnya.wechat.data.vos.MomentVO
import com.padc.ponnya.wechat.databinding.ViewholderMomentBinding
import com.padc.ponnya.wechat.utils.toDuration

class MomentViewHolder(private val binding: ViewholderMomentBinding) :
    BaseAbstractViewHolder<MomentVO>(binding) {
    override fun bindData(data: MomentVO) {
        binding.tvMomentText.text = data.text
        binding.tvLoveCount.text = data.likeCount.toString()
        binding.tvCommentCount.text = data.commentCount.toString()
        binding.tvMomentPostedTime.text = data.postedTime?.toDuration()

        with(binding.rvMomentImage) {
            val momentImageAdapter = MomentImageAdapter()
            adapter = momentImageAdapter
            layoutManager =
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL).apply {
                    gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS
                }
            momentImageAdapter.setNewData(data.images ?: listOf())
        }


    }
}