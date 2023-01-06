package com.padc.ponnya.wechat.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.padc.ponnya.wechat.adapters.ContactGroupItemAdapter
import com.padc.ponnya.wechat.adapters.ContactListItemAdapter
import com.padc.ponnya.wechat.databinding.FragmentContactsBinding

class ContactsFragment : Fragment() {
    private lateinit var binding: FragmentContactsBinding

    private lateinit var mContactGroupAdapter: ContactGroupItemAdapter
    private lateinit var mContactAdapter: ContactListItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentContactsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpAddGroupRecycler()
        setUpContactListRecycler()
    }

    private fun setUpAddGroupRecycler() {
        mContactGroupAdapter = ContactGroupItemAdapter()
        binding.rvGroupCreate.adapter = mContactGroupAdapter
        binding.rvGroupCreate.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun setUpContactListRecycler() {
        mContactAdapter = ContactListItemAdapter()
        binding.rvContactsList.adapter = mContactAdapter
        binding.rvContactsList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

}