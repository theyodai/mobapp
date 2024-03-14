
package com.example.photolent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button

class PhotoGalleryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_gallery)

        // Находим RecyclerView по его идентификатору
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_gallery)

        // Создаем список фотографий
        val photoArray = getPhotos()

        // Создаем адаптер и передаем ему список фотографий
        val adapter = PhotoAdapter(photoArray)

        // Устанавливаем LayoutManager для RecyclerView
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        // Устанавливаем адаптер для RecyclerView
        recyclerView.adapter = adapter

        val backButton = findViewById<Button>(R.id.buttonBack)
        // Устанавливаем слушатель нажатий на кнопку "Назад"
        backButton.setOnClickListener {
            // Завершаем текущую активность, чтобы вернуться на предыдущий экран
            finish()
        }
    }

    private fun getPhotos(): List<Int> {
        return listOf(
            R.drawable.photo5,
            R.drawable.photo6,
            R.drawable.photo7,
            R.drawable.photo8,
            R.drawable.photo9,
            R.drawable.photo10,
            R.drawable.photo12,
            R.drawable.photo13,
            R.drawable.photo14,
            R.drawable.photo15,
            R.drawable.photo16,
            R.drawable.photo17,
            R.drawable.photo18,
            R.drawable.photo19,
            R.drawable.photo20,


            )
    }
}
