package com.padc.ponnya.wechat.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.padc.ponnya.wechat.adapters.SelectedImageAdapter
import com.padc.ponnya.wechat.data.vos.MomentImageVO
import com.padc.ponnya.wechat.databinding.ActivityNewMomentBinding

class NewMomentActivity : BaseAbstractActivity() {
    private lateinit var binding: ActivityNewMomentBinding
    private lateinit var selectedImageAdapter: SelectedImageAdapter

    companion object {
        fun newIntent(context: Context) = Intent(context, NewMomentActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewMomentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        selectedImageAdapter = SelectedImageAdapter()
        with(binding.rvSelectedImage) {
            adapter = selectedImageAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
        val list = arrayListOf<MomentImageVO>()
        list.add(MomentImageVO("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFBXXILAje0QDVqybBe_tjXz83A1spN9GcSA&usqp=CAU"))
        list.add(MomentImageVO("https://i.stack.imgur.com/Bpdap.jpg?s=328&g=1"))
        list.add(MomentImageVO("https://i.stack.imgur.com/73QY4.jpg"))
        list.add(MomentImageVO("https://i.stack.imgur.com/Bpdap.jpg?s=328&g=1"))
        selectedImageAdapter.setNewData(list)
    }
}