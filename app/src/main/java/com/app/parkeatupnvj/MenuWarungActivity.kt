package com.app.parkeatupnvj

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.app.parkeatupnvj.adapter.MenuAdapter
import com.app.parkeatupnvj.repository.MenuRepository

class MenuWarungActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_warung)

        val tvNamaWarung = findViewById<TextView>(R.id.tvNamaWarung)
        val listMenu = findViewById<ListView>(R.id.listMenu)

        val namaWarung = intent.getStringExtra("NAMA_WARUNG")
        tvNamaWarung.text = namaWarung

        val menuList = MenuRepository.getMenuByWarung(namaWarung)

        val adapter = MenuAdapter(this, menuList)

        listMenu.adapter = adapter

        // klik menu -> buka detail menu
        listMenu.setOnItemClickListener { parent, view, position, id ->

            val menu = menuList[position]

            val intent = Intent(this, DetailMenuActivity::class.java)

            intent.putExtra("NAMA_MENU", menu.nama)
            intent.putExtra("HARGA_MENU", menu.harga)
            intent.putExtra("GAMBAR_MENU", menu.gambar)
            intent.putExtra("NAMA_WARUNG", namaWarung)

            startActivity(intent)
        }
    }
}