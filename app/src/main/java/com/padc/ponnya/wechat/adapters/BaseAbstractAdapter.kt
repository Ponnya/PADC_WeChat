package com.padc.ponnya.wechat.adapters

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.padc.ponnya.wechat.viewholders.BaseAbstractViewHolder

abstract class BaseAbstractAdapter<V : BaseAbstractViewHolder<W>, W> : RecyclerView.Adapter<V>() {
    protected var mData: ArrayList<W> = arrayListOf()

    override fun onBindViewHolder(holder: V, position: Int) {
        holder.bindData(mData[position])
    }

    override fun getItemCount() = mData.size

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(data: List<W>) {
        if (data.isEmpty()) {
            mData.clear()
        } else {
            mData = ArrayList(data)
        }
        notifyDataSetChanged()
    }

    fun appendNewData(newData: List<W>) {
        if (newData.isEmpty()) return

        val startPosition = mData.size

        mData.addAll(newData)
        notifyItemRangeInserted(startPosition, newData.size)
    }

    fun getItemAt(position: Int): W? {
        return if (position < mData.size) mData[position] else null
    }

    fun getItems(): List<W> {
        return mData
    }

    @SuppressLint("NotifyDataSetChanged")
    fun removeData(data: W) {
        mData.remove(data)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun removeGently(data: W) {
        val index = mData.indexOf(data)
        if (index == -1) return

        mData.remove(data)
        notifyItemRemoved(index)
        notifyItemRangeChanged(index, mData.size)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addNewData(data: W) {
        mData.add(data)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clearData() {
        mData = arrayListOf()
        notifyDataSetChanged()
    }
}