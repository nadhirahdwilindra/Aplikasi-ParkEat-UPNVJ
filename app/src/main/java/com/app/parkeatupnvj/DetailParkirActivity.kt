package com.app.parkeatupnvj

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.app.parkeatupnvj.database.DatabaseParkir

class DetailParkirActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_parkir)

        val dbParkir = DatabaseParkir(this)

        val imgDetail = findViewById<ImageView>(R.id.imgDetail)
        val tvNamaDetail = findViewById<TextView>(R.id.tvNamaDetail)
        val tvLokasi = findViewById<TextView>(R.id.tvLokasi)
        val tvMotorDetail = findViewById<TextView>(R.id.tvMotorDetail)
        val tvMobilDetail = findViewById<TextView>(R.id.tvMobilDetail)
        val tvStatusDetail = findViewById<TextView>(R.id.tvStatusDetail)

        val rbMotor = findViewById<RadioButton>(R.id.rbMotor)
        val rbMobil = findViewById<RadioButton>(R.id.rbMobil)
        val btnGunakan = findViewById<Button>(R.id.btnGunakan)

        // ambil data intent
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

        // lokasi
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

        // tombol gunakan
        btnGunakan.setOnClickListener {

            if (namaArea != null) {

                if (rbMotor.isChecked) {

                    if (dbParkir.cekSlotTersedia(namaArea, "Motor")) {

                        dbParkir.kurangiSlot(
                            namaArea,
                            "Motor"
                        )

                        Toast.makeText(
                            this,
                            "Slot motor berhasil digunakan",
                            Toast.LENGTH_SHORT
                        ).show()

                        finish()

                    } else {

                        Toast.makeText(
                            this,
                            "Slot motor sudah habis",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                } else if (rbMobil.isChecked) {

                    if (dbParkir.cekSlotTersedia(namaArea, "Mobil")) {

                        dbParkir.kurangiSlot(
                            namaArea,
                            "Mobil"
                        )

                        Toast.makeText(
                            this,
                            "Slot mobil berhasil digunakan",
                            Toast.LENGTH_SHORT
                        ).show()

                        finish()

                    } else {

                        Toast.makeText(
                            this,
                            "Slot mobil sudah habis",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                } else {

                    Toast.makeText(
                        this,
                        "Pilih kendaraan terlebih dahulu",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}