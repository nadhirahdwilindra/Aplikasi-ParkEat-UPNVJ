package com.app.parkeatupnvj

import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.app.parkeatupnvj.adapter.KeranjangAdapter
import com.app.parkeatupnvj.database.DatabaseKeranjang
import com.app.parkeatupnvj.model.CartWarung

class KeranjangActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var dbKeranjang: DatabaseKeranjang
    private lateinit var btnKosongkan: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keranjang)

        listView = findViewById(R.id.listKeranjangWarung)
        btnKosongkan = findViewById(R.id.btnKosongkan)

        dbKeranjang = DatabaseKeranjang(this)

        tampilKeranjang()

        // tombol kosongkan semua
        btnKosongkan.setOnClickListener {

            dbKeranjang.kosongkanKeranjang()

            Toast.makeText(
                this,
                "Semua keranjang berhasil dihapus",
                Toast.LENGTH_SHORT
            ).show()

            tampilKeranjang()
        }
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

            // hapus per warung (tombol X)
            dbKeranjang.hapusWarung(warung.namaWarung)

            Toast.makeText(
                this,
                "Keranjang ${warung.namaWarung} dihapus",
                Toast.LENGTH_SHORT
            ).show()

            tampilKeranjang()
        }

        listView.adapter = adapter
    }
}