package com.padc.ponnya.wechat.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.padc.ponnya.wechat.adapters.ChatAdapter
import com.padc.ponnya.wechat.data.vos.UserVO
import com.padc.ponnya.wechat.databinding.ActivityChatRoomBinding
import com.padc.ponnya.wechat.mvp.presenters.ChatRoomPresenter
import com.padc.ponnya.wechat.mvp.presenters.impl.ChatRoomPresenterImpl
import com.padc.ponnya.wechat.mvp.views.ChatRoomView

class ChatRoomActivity : BaseAbstractActivity(), ChatRoomView {
    private lateinit var binding: ActivityChatRoomBinding

    private lateinit var mPresenter: ChatRoomPresenter
    private lateinit var mReceiver: String

    private lateinit var mChatAdapter: ChatAdapter

    companion object {
        const val EXTRA_RECEIVER = "EXTRA_RECEIVER"
        fun newIntent(context: Context, receiver: String) =
            Intent(context, ChatRoomActivity::class.java).putExtra(EXTRA_RECEIVER, receiver)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mPresenter = getPresenter<ChatRoomPresenterImpl, ChatRoomView>()
        setUpRecyclerView()

        mReceiver = intent.getStringExtra(EXTRA_RECEIVER) ?: ""

        mPresenter.onUiReady(this, mReceiver)
    }

    private fun setUpRecyclerView() {
        mChatAdapter = ChatAdapter()
        with(binding.rvChat) {

            adapter = mChatAdapter
            val linearLayoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            linearLayoutManager.stackFromEnd = true
            layoutManager = linearLayoutManager
        }
    }

    override fun showChatMessage(chatMessage: List<UserVO>) {
        mChatAdapter.setNewData(chatMessage)
    }
}