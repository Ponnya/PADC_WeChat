package com.padc.ponnya.wechat.viewholders

import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.padc.ponnya.wechat.R
import com.padc.ponnya.wechat.adapters.MomentImageAdapter
import com.padc.ponnya.wechat.data.vos.MomentVO
import com.padc.ponnya.wechat.databinding.ViewholderMomentBinding
import com.padc.ponnya.wechat.delegates.MomentDelegate
import com.padc.ponnya.wechat.utils.toDuration

class MomentViewHolder(
    private val mDelegate: MomentDelegate,
    private val binding: ViewholderMomentBinding,
) :
    BaseAbstractViewHolder<MomentVO>(binding) {
    init {
        binding.btnLove.setOnClickListener {
            mData?.let { data -> mDelegate.onTapLike(data.momentPhone, data.postedTime) }
        }
    }

    override fun bindData(data: MomentVO) {
        mData = data
        binding.tvMomentText.text = data.text
        binding.tvLoveCount.text = data.likeCount.toString()
        binding.tvCommentCount.text = data.commentCount.toString()
        binding.tvMomentPostedTime.text = data.duration.toDuration()

        with(binding.rvMomentImage) {
            val momentImageAdapter = MomentImageAdapter()
            adapter = momentImageAdapter
            layoutManager =
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL).apply {
                    gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS
                }
            momentImageAdapter.setNewData(data.images)
        }

        if (data.isLikeMoment) {
            binding.btnLove.setBackgroundResource(R.drawable.ic_baseline_favorite_red_24dp)
        } else {
            binding.btnLove.setBackgroundResource(R.drawable.ic_baseline_favorite_border_blue_24dp)
        }

    }
}