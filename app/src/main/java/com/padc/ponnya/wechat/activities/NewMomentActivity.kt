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
import android.view.WindowManager
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.padc.ponnya.wechat.adapters.SelectedImageAdapter
import com.padc.ponnya.wechat.databinding.ActivityNewMomentBinding
import com.padc.ponnya.wechat.mvp.presenters.NewMomentPresenter
import com.padc.ponnya.wechat.mvp.presenters.impl.NewMomentPresenterImpl
import com.padc.ponnya.wechat.mvp.views.NewMomentView
import com.padc.ponnya.wechat.utils.INTENT_TYPE_IMAGE

class NewMomentActivity : BaseAbstractActivity(), NewMomentView {
    private lateinit var binding: ActivityNewMomentBinding
    private lateinit var selectedImageAdapter: SelectedImageAdapter

    private lateinit var mPresenter: NewMomentPresenter

    private var imageList: ArrayList<Bitmap> = arrayListOf()

    companion object {
        fun newIntent(context: Context) = Intent(context, NewMomentActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewMomentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mPresenter = getPresenter<NewMomentPresenterImpl, NewMomentView>()

        setUpRecyclerView()
        setUpListener()

        mPresenter.onUiReady(this)
    }

    private fun setUpRecyclerView() {
        selectedImageAdapter = SelectedImageAdapter(mPresenter)
        with(binding.rvSelectedImage) {
            adapter = selectedImageAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }

    }

    private fun setUpListener() {
        binding.btnCreateMoment.setOnClickListener {
            mPresenter.onTapCreate(binding.edtMomentContent.text.toString(), imageList)
        }
    }

    private val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { it ->
            if (it.resultCode == Activity.RESULT_OK) {
                val data: Intent? = it.data
                data?.clipData?.let { clipData ->
                    for (i in 0 until clipData.itemCount) {
                        clipData.getItemAt(i).uri?.let { image ->
                            imageList.add(image.changeToImage())
                        }
                    }
                }
                data?.data?.let { image ->
                    imageList.add(image.changeToImage())
                }
                selectedImageAdapter.setNewData(imageList)
            }
        }

    private fun Uri.changeToImage(): Bitmap {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val source = ImageDecoder.createSource(this@NewMomentActivity.contentResolver, this)
            ImageDecoder.decodeBitmap(source)
        } else {
            MediaStore.Images.Media.getBitmap(
                this@NewMomentActivity.contentResolver,
                this
            )
        }

    }

    override fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = INTENT_TYPE_IMAGE
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
        intent.action = Intent.ACTION_GET_CONTENT
        resultLauncher.launch(intent)
    }

    override fun closeNewMoment() {
        finish()
    }

    override fun focusOnEditText() {
        binding.edtMomentContent.requestFocus()
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)

    }
}