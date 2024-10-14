package com.example.rvideo

import android.annotation.SuppressLint
import com.example.rvideo.ui.theme.VideoAdapter
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rvideo.ui.Video
import com.example.rvideo.ui.theme.VideoPlayerActivity

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        // Sample video data
        val videos = listOf(
            Video("Movie 1", "https://example.com/thumbnail1.jpg", "https://example.com/video1.mp4"),
            Video("Movie 2", "https://example.com/thumbnail2.jpg", "https://example.com/video2.mp4"),
            Video("Movie 3", "https://example.com/thumbnail3.jpg", "https://example.com/video3.mp4"),
            Video("Movie 4", "https://example.com/thumbnail4.jpg", "https://example.com/video4.mp4")
        )

        // Specify the lambda parameter type
        val adapter = VideoAdapter(videos) { video: Video -> // Explicitly specify the type
            // Start VideoPlayerActivity with the video URL
            val intent = Intent(this, VideoPlayerActivity::class.java)
            intent.putExtra("videoUrl", video.videoUrl)
            startActivity(intent)
        }

        recyclerView.adapter = adapter
    }

}
