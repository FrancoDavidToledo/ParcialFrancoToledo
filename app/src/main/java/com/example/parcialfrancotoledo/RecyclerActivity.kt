package com.example.parcialfrancotoledo

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AlumnosAdapter
    private lateinit var nombre: String
    private var edad:Int = 0
    @SuppressLint("MissingInflatedId")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        val bundle = intent.extras
        nombre = bundle!!.getString("nombre", "")
        edad = bundle!!.getString("age", "").toInt()

        recyclerView = findViewById(R.id.reciclerViewAlumnos)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = AlumnosAdapter(applicationContext)
        recyclerView.adapter = adapter

        adapter.submitList(getListadoAlumnos())


        adapter.onItemClickListener = { alumno ->

            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("name", alumno.nombre)
            intent.putExtra("edad", alumno.edad.toString())
            intent.putExtra("url", alumno.url)
            startActivity(intent)
        }
    }


    private fun getListadoAlumnos(): MutableList<Alumnos>? {
        return mutableListOf(
            Alumnos(1 ,"Franco Armani"       ,36 ,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRI7awZLbfkDZi_ylRGGKkto7fiWT4NI0XrBfqfsZWD&usqp=CAE&s"),
            Alumnos(2 ,"Juan Foyth"          ,25 ,"https://img.a.transfermarkt.technology/portrait/big/480763-1662668281.jpg?lm=1"),
            Alumnos(3 ,"Nicolás Tagliafico"  ,30 ,"https://as01.epimg.net/img/comunes/fotos/fichas/deportistas/t/tag/large/20356.png"),
            Alumnos(4 ,"Gonzalo Montiel"     ,26 ,"https://images.pagina12.com.ar/styles/focal_content_1200x1050/public/2023-02/698649-whatsapp-20image-202023-02-17-20at-2018-26-25.jpeg?h=34bbd072&itok=lcNOmQJi"),
            Alumnos(5 ,"Leandro Paredes"     ,28 ,"https://img.a.transfermarkt.technology/portrait/big/166237-1639582931.jpg?lm=1"),
            Alumnos(6 ,"Germán Pezzella"     ,31 ,"https://t3.gstatic.com/licensed-image?q=tbn:ANd9GcQ62D6J52UHW_nDlI243oRTnf_0LVAUeoouieHdcNDv0aYUqDg-wQNwSlilzwUrg7z7"),
            Alumnos(7 ,"Rodrigo De Paul"     ,29 ,"https://s.hs-data.com/bilder/spieler/gross/213013.jpg"),
            Alumnos(8 ,"Marcos Acuña"        ,31 ,"https://img.a.transfermarkt.technology/portrait/big/60410-1668181014.jpg?lm=1"),
            Alumnos(9 ,"Julián Alvarez"      ,23 ,"https://t2.gstatic.com/licensed-image?q=tbn:ANd9GcTDARC1e3n7MRninpFClRLE2IMSBmFPzft-WH2r5VQqKyt34t3LnQA_42Bec-Njjwc1"),
            Alumnos(10,"Lionel Messi"       ,35 ,"https://t3.gstatic.com/licensed-image?q=tbn:ANd9GcTmMSk4EUfCgAqlsjDNmFpgRYSfv7Ms_hubGzPvdLwpzNw3cS_fZX-IiLZHXwPCwTFc"),
            Alumnos(11,"Angel Di María"     ,35 ,"https://fotos.perfil.com/2023/04/25/trim/720/410/di-maria-1554574.jpg"),
            Alumnos(12,"Gerónimo Rulli"     ,31 ,"https://upload.wikimedia.org/wikipedia/commons/f/fa/Real_Sociedad_-_Red_Bull_Salzburgo_57_%2839408620015%29_%28cropped%29.jpg"),
            Alumnos(13,"Cristian Romero"    ,25 ,"https://img.a.transfermarkt.technology/portrait/big/355915-1665609429.jpg?lm=1"),
            Alumnos(14,"Exequiel Palacios"  ,24 ,"https://img.a.transfermarkt.technology/portrait/header/401578-1658913508.jpg?lm=1"),
            Alumnos(15,"Angel Correa"       ,28 ,"https://img.a.transfermarkt.technology/portrait/header/266807-1683637670.jpg?lm=1"),
            Alumnos(16,"Thiago Almada"      ,22 ,"https://img.a.transfermarkt.technology/portrait/header/576028-1678216180.jpg?lm=1"),
            Alumnos(17,"Alejandro Gómez"    ,35 ,"https://img.a.transfermarkt.technology/portrait/header/20005-1670101551.jpg?lm=1"),
            Alumnos(18,"Guido Rodríguez"    ,29 ,"https://img.a.transfermarkt.technology/portrait/header/342385-1668181269.jpg?lm=1"),
            Alumnos(19,"Nicolás Otamendi"   ,35 ,"https://img.a.transfermarkt.technology/portrait/header/54781-1669835534.jpg?lm=1"),
            Alumnos(20,"Alexis Mac Allister",24 ,"https://img.a.transfermarkt.technology/portrait/header/534033-1669835342.jpg?lm=1"),
            Alumnos(21,"Paulo Dybala"       ,29 ,"https://img.a.transfermarkt.technology/portrait/header/206050-1641810495.jpg?lm=1"),
            Alumnos(22,"Lautaro Martínez"   ,25 ,"https://img.a.transfermarkt.technology/portrait/header/406625-1661352429.jpg?lm=1"),
            Alumnos(23,"Emiliano Martínez"  ,30 ,"https://img.a.transfermarkt.technology/portrait/header/111873-1668180824.jpg?lm=1"),
            Alumnos(24,"Enzo Fernández"     ,22 ,"https://img.a.transfermarkt.technology/portrait/header/648195-1669894717.jpg?lm=1"),
            Alumnos(25,"Lisandro Martínez"  ,25 ,"https://img.a.transfermarkt.technology/portrait/header/480762-1680681507.jpg?lm=1"),
            Alumnos(26,"Nahuel Molina"      ,25 ,"https://img.a.transfermarkt.technology/portrait/header/424042-1629455297.jpg?lm=1"),
            Alumnos(27,nombre.toString(),edad.toInt(), "https://t2.gstatic.com/licensed-image?q=tbn:ANd9GcTZbSyOUSSHN8YMCJANTUSHBbQNjDVoh0rSTZ_BRq9fE-Dj-U9CTW6AanKOVTlbGJTQ"),
         )
    }
}
