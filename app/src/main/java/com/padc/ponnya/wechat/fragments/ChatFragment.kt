package com.padc.ponnya.wechat.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.padc.ponnya.wechat.adapters.ChatItemAdapter
import com.padc.ponnya.wechat.databinding.FragmentChatBinding

class ChatFragment : Fragment() {
    private lateinit var binding: FragmentChatBinding

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
        setUpChatsListRecycler()
    }

    private fun setUpChatsListRecycler() {
        mChatsAdapter = ChatItemAdapter()
        binding.rvChatsList.adapter = mChatsAdapter
        binding.rvChatsList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

}