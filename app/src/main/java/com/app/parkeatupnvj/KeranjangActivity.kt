package com.app.parkeatupnvj

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.app.parkeatupnvj.adapter.KeranjangAdapter
import com.app.parkeatupnvj.model.CartWarung
import com.app.parkeatupnvj.repository.CartManager

class KeranjangActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keranjang)

        val listView = findViewById<ListView>(R.id.listKeranjangWarung)

        val cartList = CartManager.cartList

        // kelompokkan menu berdasarkan warung
        val grouped = cartList.groupBy { it.namaWarung }

        val listWarung = grouped.map {

            CartWarung(
                namaWarung = it.key,
                daftarMenu = it.value
            )

        }

        val adapter = KeranjangAdapter(this, listWarung)

        listView.adapter = adapter
    }
}