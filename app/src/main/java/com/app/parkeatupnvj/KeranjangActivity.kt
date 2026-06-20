package com.app.parkeatupnvj

import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.app.parkeatupnvj.adapter.KeranjangAdapter
import com.app.parkeatupnvj.database.DatabaseKeranjang
import com.app.parkeatupnvj.model.CartWarung

class KeranjangActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var dbKeranjang: DatabaseKeranjang

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keranjang)

        listView = findViewById(R.id.listKeranjangWarung)

        dbKeranjang = DatabaseKeranjang(this)

        tampilKeranjang()
    }

    private fun tampilKeranjang() {

        val cartList = dbKeranjang.getSemuaKeranjang()

        val grouped = cartList.groupBy { it.namaWarung }

        val listWarung = grouped.map {

            CartWarung(
                namaWarung = it.key,
                daftarMenu = it.value
            )
        }

        val adapter = KeranjangAdapter(
            this,
            listWarung
        ) { warung ->

            // delete semua menu dari warung ini
            dbKeranjang.hapusWarung(warung.namaWarung)

            Toast.makeText(
                this,
                "Keranjang ${warung.namaWarung} dihapus",
                Toast.LENGTH_SHORT
            ).show()

            // refresh list
            tampilKeranjang()
        }

        listView.adapter = adapter
    }
}