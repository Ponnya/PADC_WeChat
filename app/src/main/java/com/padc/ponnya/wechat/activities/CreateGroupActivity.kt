package com.padc.ponnya.wechat.activities

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.padc.ponnya.wechat.adapters.ContactListItemAdapter
import com.padc.ponnya.wechat.adapters.SelectedContactItemAdapter
import com.padc.ponnya.wechat.databinding.ActivityCreateGroupBinding

class CreateGroupActivity : BaseAbstractActivity() {
    private lateinit var binding: ActivityCreateGroupBinding

    private lateinit var mSelectContactsListAdapter: SelectedContactItemAdapter
    private lateinit var mContactsListAdapter: ContactListItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateGroupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpSelectedRecycler()
        setUpContactListRecycler()
    }

    private fun setUpSelectedRecycler() {
        mSelectContactsListAdapter = SelectedContactItemAdapter()
        binding.rvSelectedContact.adapter = mSelectContactsListAdapter
        binding.rvSelectedContact.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun setUpContactListRecycler() {
        mContactsListAdapter = ContactListItemAdapter()
        binding.rvContactsList.adapter = mContactsListAdapter
        binding.rvContactsList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

}