package com.app.parkeatupnvj

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetailParkirActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_parkir)

        val imgDetail = findViewById<ImageView>(R.id.imgDetail)
        val tvNamaDetail = findViewById<TextView>(R.id.tvNamaDetail)
        val tvLokasi = findViewById<TextView>(R.id.tvLokasi)
        val tvMotorDetail = findViewById<TextView>(R.id.tvMotorDetail)
        val tvMobilDetail = findViewById<TextView>(R.id.tvMobilDetail)
        val tvStatusDetail = findViewById<TextView>(R.id.tvStatusDetail)
        val btnGunakan = findViewById<Button>(R.id.btnGunakan)

        // ambil data dari intent
        val namaArea = intent.getStringExtra("NAMA_AREA")
        val motor = intent.getIntExtra("MOTOR", 0)
        val mobil = intent.getIntExtra("MOBIL", 0)
        val status = intent.getStringExtra("STATUS")
        val gambar = intent.getIntExtra("GAMBAR", 0)

        // tampilkan data
        tvNamaDetail.text = namaArea
        tvMotorDetail.text = "Motor : $motor Slot"
        tvMobilDetail.text = "Mobil : $mobil Slot"
        tvStatusDetail.text = "Status : $status"
        imgDetail.setImageResource(gambar)

        // lokasi beda-beda sesuai area
        when (namaArea) {

            "Area Parkir FEB" ->
                tvLokasi.text = "Lokasi : Depan Gedung FEB"

            "Area Parkir Hukum" ->
                tvLokasi.text = "Lokasi : Samping Fakultas Hukum"

            "Area Parkir Rektorat" ->
                tvLokasi.text = "Lokasi : Area Gedung Rektorat"

            "Area Parkir FIK" ->
                tvLokasi.text = "Lokasi : Dekat Fakultas Ilmu Komputer"

            "Area Parkir FISIP" ->
                tvLokasi.text = "Lokasi : Samping Gedung FISIP"

            "Area Parkir APU" ->
                tvLokasi.text = "Lokasi : Area Aula Pertemuan UPN"

            "Area Parkir Kantin" ->
                tvLokasi.text = "Lokasi : Sebelah Kantin Kampus"

        }

        btnGunakan.setOnClickListener {

            Toast.makeText(
                this,
                "Silakan menuju $namaArea",
                Toast.LENGTH_SHORT
            ).show()

        }

    }

}