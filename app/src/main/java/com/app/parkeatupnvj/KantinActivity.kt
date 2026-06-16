package com.app.parkeatupnvj

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.app.parkeatupnvj.adapter.WarungAdapter
import com.app.parkeatupnvj.repository.KantinRepository

class KantinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kantin_screen)

        val listView = findViewById<ListView>(R.id.listWarung)

        val warungList = KantinRepository.getWarungList()

        val adapter = WarungAdapter(this, warungList)

        listView.adapter = adapter

        // Klik item warung
        listView.setOnItemClickListener { parent, view, position, id ->

            val warung = warungList[position]

            val intent = Intent(this, MenuWarungActivity::class.java)
            intent.putExtra("NAMA_WARUNG", warung.nama)

            startActivity(intent)
        }
    }
}