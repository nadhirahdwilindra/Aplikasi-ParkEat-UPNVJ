package com.app.parkeatupnvj

import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.parkeatupnvj.adapter.ParkirAdapter
import com.app.parkeatupnvj.model.Parkir

class ParkirActivity : AppCompatActivity() {

    private lateinit var rvParkir: RecyclerView
    private lateinit var listParkir: ArrayList<Parkir>

    private lateinit var rbList: RadioButton
    private lateinit var rbGrid: RadioButton
    private lateinit var rbCard: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parkir)

        rvParkir = findViewById(R.id.rvParkir)

        rbList = findViewById(R.id.rbList)
        rbGrid = findViewById(R.id.rbGrid)
        rbCard = findViewById(R.id.rbCard)

        listParkir = arrayListOf(

            Parkir(
                "Area Parkir FEB",
                42,
                10,
                "Tersedia",
                R.drawable.parking_icon
            ),

            Parkir(
                "Area Parkir Hukum",
                18,
                4,
                "Hampir Penuh",
                R.drawable.parking_icon
            ),

            Parkir(
                "Area Parkir Rektorat",
                0,
                0,
                "Penuh",
                R.drawable.parking_icon
            ),

            Parkir(
                "Area Parkir FIK",
                25,
                8,
                "Tersedia",
                R.drawable.parking_icon
            ),

            Parkir(
                "Area Parkir FISIP",
                35,
                7,
                "Tersedia",
                R.drawable.parking_icon
            ),

            Parkir(
                "Area Parkir APU",
                12,
                2,
                "Hampir Penuh",
                R.drawable.parking_icon
            ),

            Parkir(
                "Area Parkir Kantin",
                0,
                0,
                "Penuh",
                R.drawable.parking_icon
            )

        )

        tampilGrid()

        rbGrid.setOnClickListener {
            tampilGrid()
        }

        rbList.setOnClickListener {
            tampilList()
        }

        rbCard.setOnClickListener {
            tampilCard()
        }

    }

    private fun tampilGrid() {

        rvParkir.layoutManager = GridLayoutManager(this, 2)

        rvParkir.adapter = ParkirAdapter(
            listParkir,
            R.layout.item_parkir
        ) { parkir ->

            val intent = Intent(this, DetailParkirActivity::class.java)

            intent.putExtra("NAMA_AREA", parkir.namaArea)
            intent.putExtra("MOTOR", parkir.motor)
            intent.putExtra("MOBIL", parkir.mobil)
            intent.putExtra("STATUS", parkir.status)
            intent.putExtra("GAMBAR", parkir.gambar)

            startActivity(intent)

        }

    }

    private fun tampilList() {

        rvParkir.layoutManager = LinearLayoutManager(this)

        rvParkir.adapter = ParkirAdapter(
            listParkir,
            R.layout.item_parkir_list
        ) { parkir ->

            val intent = Intent(this, DetailParkirActivity::class.java)

            intent.putExtra("NAMA_AREA", parkir.namaArea)
            intent.putExtra("MOTOR", parkir.motor)
            intent.putExtra("MOBIL", parkir.mobil)
            intent.putExtra("STATUS", parkir.status)
            intent.putExtra("GAMBAR", parkir.gambar)

            startActivity(intent)

        }

    }

    private fun tampilCard() {

        rvParkir.layoutManager = LinearLayoutManager(this)

        rvParkir.adapter = ParkirAdapter(
            listParkir,
            R.layout.item_parkir_card
        ) { parkir ->

            val intent = Intent(this, DetailParkirActivity::class.java)

            intent.putExtra("NAMA_AREA", parkir.namaArea)
            intent.putExtra("MOTOR", parkir.motor)
            intent.putExtra("MOBIL", parkir.mobil)
            intent.putExtra("STATUS", parkir.status)
            intent.putExtra("GAMBAR", parkir.gambar)

            startActivity(intent)

        }

    }

}