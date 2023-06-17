package com.example.inventorapplication

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailedActivity : AppCompatActivity() {

    companion object{
        const val DATA = "data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        val dataBorn = resources.getStringArray(R.array.data_born)
        val dataThing = resources.getStringArray(R.array.data_temuan)

        val imgInventor: ImageView = findViewById(R.id.img_inventor)
        val tvName: TextView = findViewById(R.id.tv_nama_inventor)
        val tvDescription: TextView = findViewById(R.id.tv_deskripsi_inventor)
        val tvBorn: TextView = findViewById(R.id.tv_born)
        val tvThing:TextView = findViewById(R.id.tv_thing)

        val data = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Inventor>(DATA, Inventor::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Inventor>(DATA)
        }

        if (data != null){
            imgInventor.setImageResource(data.photo)
            tvName.text = data.name
            tvDescription.text = data.description
        }

        when(data?.name){
            "Albert Einstein" ->{
                tvBorn.text = dataBorn[0]
                tvThing.text = dataThing[0]
            }
            "Alessandro Volta" ->{
                tvBorn.text = dataBorn[1]
                tvThing.text = dataThing[1]
            }
            "Alexander Graham Bell" ->{
                tvBorn.text = dataBorn[2]
                tvThing.text = dataThing[2]
            }
            "Alfred Nobel" ->{
                tvBorn.text = dataBorn[3]
                tvThing.text = dataThing[3]
            }
            "Antonie van Leeuwenhoek" ->{
                tvBorn.text = dataBorn[4]
                tvThing.text = dataThing[4]
            }
            "Antonio Meucci" ->{
                tvBorn.text = dataBorn[5]
                tvThing.text = dataThing[5]
            }
            "Benjamin franklin" ->{
                tvBorn.text = dataBorn[6]
                tvThing.text = dataThing[6]
            }
            "Blaise Pascal" ->{
                tvBorn.text = dataBorn[7]
                tvThing.text = dataThing[7]
            }
            "Christians Huygens" ->{
                tvBorn.text = dataBorn[8]
                tvThing.text = dataThing[8]
            }
            "Guglielmo Marconi" ->{
                tvBorn.text = dataBorn[9]
                tvThing.text = dataThing[9]
            }

        }

    }
}