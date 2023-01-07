package com.padc.ponnya.wechat.activities

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.padc.ponnya.wechat.adapters.ChatAdapter
import com.padc.ponnya.wechat.data.vos.UserVO
import com.padc.ponnya.wechat.databinding.ActivityChatRoomBinding
import com.padc.ponnya.wechat.mvp.presenters.ChatRoomPresenter
import com.padc.ponnya.wechat.mvp.presenters.impl.ChatRoomPresenterImpl
import com.padc.ponnya.wechat.mvp.views.ChatRoomView
import com.padc.ponnya.wechat.utils.INTENT_TYPE_IMAGE

class ChatRoomActivity : BaseAbstractActivity(), ChatRoomView {
    private lateinit var binding: ActivityChatRoomBinding

    private lateinit var mPresenter: ChatRoomPresenter
    private lateinit var mReceiver: String
    private lateinit var mName: String
    private lateinit var mProfilePic: String

    private lateinit var mChatAdapter: ChatAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    private var mImage: Bitmap? = null

    companion object {
        const val EXTRA_RECEIVER = "EXTRA_RECEIVER"
        const val EXTRA_NAME = "EXTRA_NAME"
        const val EXTRA_PROFILE_PIC = "EXTRA_PROFILE_PIC"
        fun newIntent(context: Context, receiver: String, name: String, profilePic: String) =
            Intent(context, ChatRoomActivity::class.java)
                .putExtra(EXTRA_RECEIVER, receiver)
                .putExtra(EXTRA_NAME, name)
                .putExtra(EXTRA_PROFILE_PIC, profilePic)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mPresenter = getPresenter<ChatRoomPresenterImpl, ChatRoomView>()
        setUpRecyclerView()
        setUpListener()
        getExtraData()
        setData()

        mPresenter.onUiReady(this, mReceiver)
    }

    private fun setUpRecyclerView() {
        mChatAdapter = ChatAdapter()
        with(binding.rvChat) {

            adapter = mChatAdapter
            linearLayoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            linearLayoutManager.stackFromEnd = true
            layoutManager = linearLayoutManager
        }
    }

    private fun setUpListener() {
        binding.btnMessageSend.setOnClickListener {
            with(binding.edtChatMessage.text.toString()) {
                if (isNotBlank()) {
                    mPresenter.onTapSend(mReceiver, this, "", mName, mProfilePic)
                }
                binding.edtChatMessage.text = null
                binding.edtChatMessage.hideKeyboard()
            }

        }
    }

    private fun getExtraData() {
        mReceiver = intent.getStringExtra(EXTRA_RECEIVER) ?: ""
        mName = intent.getStringExtra(EXTRA_NAME) ?: ""
        mProfilePic = intent.getStringExtra(EXTRA_PROFILE_PIC) ?: ""
    }

    private fun setData() {
        Glide.with(binding.root)
            .load(mProfilePic)
            .into(binding.ivChatProfile)

        binding.tvChatPersonName.text = mName
    }

    override fun showChatMessage(chatMessage: List<UserVO>) {
        mChatAdapter.setNewData(chatMessage)
        binding.rvChat.layoutManager?.scrollToPosition(chatMessage.size - 1)
    }

    override fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = INTENT_TYPE_IMAGE
        intent.action = Intent.ACTION_GET_CONTENT
        resultLauncher.launch(intent)
    }

    private val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { it ->
            if (it.resultCode == Activity.RESULT_OK) {
                val data: Intent? = it.data
                data?.data?.let { image ->
                    mImage = image.changeToImage()
                }

            }
        }

    private fun Uri.changeToImage(): Bitmap {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val source = ImageDecoder.createSource(this@ChatRoomActivity.contentResolver, this)
            ImageDecoder.decodeBitmap(source)
        } else {
            MediaStore.Images.Media.getBitmap(
                this@ChatRoomActivity.contentResolver,
                this
            )
        }

    }
}