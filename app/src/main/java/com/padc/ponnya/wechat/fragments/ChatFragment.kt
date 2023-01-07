package com.padc.ponnya.wechat.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.padc.ponnya.wechat.activities.ChatRoomActivity
import com.padc.ponnya.wechat.adapters.ChatItemAdapter
import com.padc.ponnya.wechat.data.vos.UserVO
import com.padc.ponnya.wechat.databinding.FragmentChatBinding
import com.padc.ponnya.wechat.mvp.presenters.ChatFragmentPresenter
import com.padc.ponnya.wechat.mvp.presenters.impl.ChatFragmentPresenterImpl
import com.padc.ponnya.wechat.mvp.views.ChatFragmentView

class ChatFragment : BaseAbstractFragment(), ChatFragmentView {
    private lateinit var binding: FragmentChatBinding

    private lateinit var mPresenter: ChatFragmentPresenter

    private lateinit var mChatsAdapter: ChatItemAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter = getPresenter<ChatFragmentPresenterImpl, ChatFragmentView>()
        setUpChatsListRecycler()
        mPresenter.onUiReady(this)
    }

    private fun setUpChatsListRecycler() {
        mChatsAdapter = ChatItemAdapter(mPresenter)
        binding.rvChatsList.adapter = mChatsAdapter
        binding.rvChatsList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    override fun showChatList(chatList: List<UserVO>) {
        mChatsAdapter.setNewData(chatList)
    }

    override fun openChatRoom(receiver: String, name: String, profilePic: String) {
        startActivity(context?.let { ChatRoomActivity.newIntent(it, receiver, name, profilePic) })
    }

}