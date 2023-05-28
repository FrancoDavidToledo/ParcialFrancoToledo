package com.example.parcialfrancotoledo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AlumnosAdapter(val context: Context) : ListAdapter<Alumnos, AlumnosAdapter.ViewHolder>(DiffCallBack) {

    lateinit var onItemClickListener: (Alumnos) -> Unit

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val nombre: TextView = view.findViewById(R.id.textViewNombre)
        private val edad: TextView = view.findViewById(R.id.textViewEdad)
        private val imagen: ImageView = view.findViewById(R.id.imageViewImagen)

        fun bind (alumno: Alumnos) {
            nombre.text = "Nombre: " + alumno.nombre
            edad.text = "Edad: " + alumno.edad.toString()

            Glide.with(context)
                .load(alumno.url)
               .into(imagen)

            view.setOnClickListener {
                onItemClickListener(alumno)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlumnosAdapter.ViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlumnosAdapter.ViewHolder, position: Int) {
        val pokemon = getItem(position)
        holder.bind(pokemon)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Alumnos>() {
        override fun areItemsTheSame(oldItem: Alumnos, newItem: Alumnos): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Alumnos, newItem: Alumnos): Boolean {
            return oldItem == newItem
        }
    }
}
