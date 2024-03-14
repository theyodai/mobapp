package com.example.photolent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var timerTextView: TextView
    private var elapsedTimeInSeconds: Long = 0
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable
    private val intervalMillis: Long = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        timerTextView = findViewById(R.id.timerTextView)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = PhotoAdapter(getPhotos())

        handler = Handler()
        runnable = object : Runnable {
            override fun run() {
                elapsedTimeInSeconds++
                updateTimerText()
                handler.postDelayed(this, intervalMillis)
            }
        }
        handler.postDelayed(runnable, intervalMillis)

        val buttonOpenWebsite = findViewById<Button>(R.id.buttonOpenWebsite)
        buttonOpenWebsite.setOnClickListener {
            openShutterstockWebsite()
        }

        val buttonOpenPinterest = findViewById<Button>(R.id.buttonOpenPinterest)
        buttonOpenPinterest.setOnClickListener {
            openPinterest()
        }


        val buttonShowGallery = findViewById<Button>(R.id.buttonShowGallery)
        buttonShowGallery.setOnClickListener {
            val intent = Intent(this, PhotoGalleryActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getPhotos(): List<Int> {
        return listOf(
            R.drawable.photo1,
            R.drawable.photo2,

        )
    }

    private fun updateTimerText() {
        val hours = elapsedTimeInSeconds / 3600
        val minutes = (elapsedTimeInSeconds % 3600) / 60
        val seconds = elapsedTimeInSeconds % 60
        val timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds)
        timerTextView.text = timeString
    }

    private fun openShutterstockWebsite() {
        val websiteUri = Uri.parse("https://www.shutterstock.com/ru/")
        val intent = Intent(Intent.ACTION_VIEW, websiteUri)
        startActivity(intent)
    }

    private fun openPinterest() {
        val webView = WebView(this)
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://ru.pinterest.com/")
        setContentView(webView)
    }
}
