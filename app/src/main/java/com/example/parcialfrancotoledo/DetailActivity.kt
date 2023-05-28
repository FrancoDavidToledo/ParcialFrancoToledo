package com.example.parcialfrancotoledo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    private lateinit var textViewNombre: TextView
    private lateinit var textViewEdad: TextView
    private lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        textViewNombre = findViewById(R.id.textViewNombre)
        textViewEdad = findViewById(R.id.textViewEdad)
        imageView = findViewById(R.id.imageViewImagen)

        val bundle = intent.extras
        val nombre = bundle?.getString("name", "")
        val edad = bundle?.getString("edad", "")
        val url = bundle?.getString("url") ?: ""

        textViewNombre.text = nombre
        textViewEdad.text = "Edad: "+edad
        Glide.with(applicationContext)
            .load(url)
            .into(imageView)
    }
}