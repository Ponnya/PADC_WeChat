package com.padc.ponnya.wechat.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.padc.ponnya.wechat.adapters.MomentAdapter
import com.padc.ponnya.wechat.databinding.FragmentMomentBinding

class MomentFragment : Fragment() {
    private lateinit var binding: FragmentMomentBinding
    private lateinit var momentAdapter: MomentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMomentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        momentAdapter = MomentAdapter()
        with(binding.rvMoment) {
            adapter = momentAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

}