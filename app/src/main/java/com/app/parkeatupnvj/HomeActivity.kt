package com.app.parkeatupnvj

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val nama = intent.getStringExtra("NAMA_USER")

        val tvHalo = findViewById<TextView>(R.id.tvHalo)
        val btnKantin = findViewById<CardView>(R.id.cardKantin)
        val btnKeranjang = findViewById<ImageView>(R.id.btnKeranjang)
        val btnParkir = findViewById<CardView>(R.id.cardParkir)

        tvHalo.text = "Halo, $nama!"

        // buka halaman kantin
        btnKantin.setOnClickListener {

            val intent = Intent(this, KantinActivity::class.java)
            startActivity(intent)

        }

        // buka halaman keranjang
        btnKeranjang.setOnClickListener {

            val intent = Intent(this, KeranjangActivity::class.java)
            startActivity(intent)

        }

        // buka halaman parkir
        btnParkir.setOnClickListener {

            val intent = Intent(this,
                ParkirActivity::class.java)
            startActivity(intent)

        }
    }
}