package com.padc.ponnya.wechat.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.padc.ponnya.wechat.databinding.FragmentMomentBinding

class MomentFragment : Fragment() {
    private lateinit var binding: FragmentMomentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMomentBinding.inflate(inflater, container, false)
        return binding.root
    }

}