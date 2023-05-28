package com.example.parcialfrancotoledo

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var EditTextNombre: EditText
    private lateinit var EditTextEdad: EditText
    private lateinit var button: Button

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //se relacionan con el layout
        button = findViewById(R.id.button)
        EditTextNombre = findViewById(R.id.editTextTextPersonName)
        EditTextEdad = findViewById(R.id.editTextEdad)


            button.setOnClickListener {

                val nombre = EditTextNombre.text.toString()
                val edad = EditTextEdad.text.toString()
                if (nombre != "" && edad != "") {
                    val intentar = Intent(this, RecyclerActivity::class.java)
                    intentar.putExtra("nombre", nombre)
                    intentar.putExtra("age", edad)
                    startActivity(intentar)
                } else
                {
                    Toast.makeText(this,"Debe cargar el nombre y la edad", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
