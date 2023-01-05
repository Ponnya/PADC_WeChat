package com.padc.ponnya.wechat.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.padc.ponnya.wechat.adapters.MomentAdapter
import com.padc.ponnya.wechat.data.vos.MomentVO
import com.padc.ponnya.wechat.databinding.FragmentMomentBinding
import com.padc.ponnya.wechat.mvp.presenters.MomentFragmentPresenter
import com.padc.ponnya.wechat.mvp.presenters.impl.MomentFragmentPresenterImpl
import com.padc.ponnya.wechat.mvp.views.MomentFragmentView

class MomentFragment : BaseAbstractFragment(), MomentFragmentView {
    private lateinit var binding: FragmentMomentBinding
    private lateinit var momentAdapter: MomentAdapter
    private lateinit var mPresenter: MomentFragmentPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentMomentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter = getPresenter<MomentFragmentPresenterImpl, MomentFragmentView>()
        setUpRecyclerView()
        mPresenter.onUiReady(this)
    }

    private fun setUpRecyclerView() {
        momentAdapter = MomentAdapter(mPresenter)
        with(binding.rvMoment) {
            adapter = momentAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

    override fun showData(momentList: List<MomentVO>) {
        momentAdapter.setNewData(momentList)
    }

}