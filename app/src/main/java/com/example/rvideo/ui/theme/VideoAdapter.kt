package com.example.rvideo.ui.theme

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rvideo.R
import com.example.rvideo.ui.Video
import com.squareup.picasso.Picasso

@Suppress("DEPRECATION")
class VideoAdapter(
    private val videos: List<Video>,
    private val onItemClick: (Video) -> Unit
) : RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

    inner class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.videoTitle)
        val thumbnail: ImageView = itemView.findViewById(R.id.videoThumbnail)

        init {
            itemView.setOnClickListener {
                onItemClick(videos[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_video, parent, false)
        return VideoViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val video = videos[position]
        holder.title.text = video.title
        Picasso.get().load(video.thumbnailUrl).into(holder.thumbnail)
    }

    override fun getItemCount(): Int = videos.size
}
