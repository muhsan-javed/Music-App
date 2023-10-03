package com.muhsantech.musicapp.adapters

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.muhsantech.musicapp.models.Data
import com.muhsantech.musicapp.models.MyData

class MyAdapter(
    val context :Activity, val dataList : List<Data>):
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = dataList.size

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    }
}