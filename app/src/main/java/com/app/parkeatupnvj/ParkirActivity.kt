package com.app.parkeatupnvj

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.parkeatupnvj.adapter.ParkirAdapter
import com.app.parkeatupnvj.database.DatabaseParkir
import com.app.parkeatupnvj.model.Parkir

class ParkirActivity : AppCompatActivity() {

    private lateinit var rvParkir: RecyclerView
    private lateinit var listParkir: ArrayList<Parkir>
    private lateinit var dbParkir: DatabaseParkir

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

        dbParkir = DatabaseParkir(this)
        listParkir = dbParkir.getAllParkir()

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

    private fun bukaDetail(parkir: Parkir) {

        // kalau penuh jangan masuk detail
        if (parkir.status == "Penuh") {

            Toast.makeText(
                this,
                "Area parkir penuh",
                Toast.LENGTH_SHORT
            ).show()

        } else {

            val intent = Intent(this, DetailParkirActivity::class.java)

            intent.putExtra("NAMA_AREA", parkir.namaArea)
            intent.putExtra("MOTOR", parkir.motor)
            intent.putExtra("MOBIL", parkir.mobil)
            intent.putExtra("STATUS", parkir.status)
            intent.putExtra("GAMBAR", parkir.gambar)

            startActivity(intent)
        }
    }

    private fun tampilGrid() {

        rvParkir.layoutManager = GridLayoutManager(this, 2)

        rvParkir.adapter = ParkirAdapter(
            listParkir,
            R.layout.item_parkir
        ) { parkir ->

            bukaDetail(parkir)

        }
    }

    private fun tampilList() {

        rvParkir.layoutManager = LinearLayoutManager(this)

        rvParkir.adapter = ParkirAdapter(
            listParkir,
            R.layout.item_parkir_list
        ) { parkir ->

            bukaDetail(parkir)

        }
    }

    private fun tampilCard() {

        rvParkir.layoutManager = LinearLayoutManager(this)

        rvParkir.adapter = ParkirAdapter(
            listParkir,
            R.layout.item_parkir_card
        ) { parkir ->

            bukaDetail(parkir)

        }
    }

    override fun onResume() {
        super.onResume()

        listParkir = dbParkir.getAllParkir()

        if (rbGrid.isChecked) {
            tampilGrid()

        } else if (rbList.isChecked) {
            tampilList()

        } else {
            tampilCard()
        }
    }
}