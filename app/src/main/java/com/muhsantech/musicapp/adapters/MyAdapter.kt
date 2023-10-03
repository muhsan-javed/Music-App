package com.muhsantech.musicapp.adapters

import android.app.Activity
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.muhsantech.musicapp.R
import com.muhsantech.musicapp.models.Data
import com.squareup.picasso.Picasso

class MyAdapter(
    val context :Activity, val dataList : List<Data>):
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create the view in case thw layout manager fails to create view for the data
        val itmeView = LayoutInflater.from(context).inflate(R.layout.each_item, parent, false)
        return ViewHolder(itmeView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Populate the data into the view
        val currentData = dataList[position]

        val mediaPlayer = MediaPlayer.create(context, currentData.preview.toUri())
        holder.title.text = currentData.title

        Picasso.get().load(currentData.album.cover).into(holder.image)

        holder.play.setOnClickListener {
            mediaPlayer.start()
        }
        holder.pause.setOnClickListener {
            mediaPlayer.stop()
        }

    }

    override fun getItemCount(): Int = dataList.size

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        // create the view in case thw layout manager fails to create view for the datav
        val image :ImageView
        val title :TextView
        val play:ImageButton
        val pause:ImageButton

        init {
            image = itemView.findViewById(R.id.imageView)
            title = itemView.findViewById(R.id.titleTv)
            play = itemView.findViewById(R.id.btn_play)
            pause = itemView.findViewById(R.id.btn_pause)
        }
    }
}