package com.app.parkeatupnvj.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.app.parkeatupnvj.R
import com.app.parkeatupnvj.model.CartWarung

class KeranjangAdapter(
    private val context: Context,
    private val listWarung: List<CartWarung>
) : BaseAdapter() {

    override fun getCount(): Int {
        return listWarung.size
    }

    override fun getItem(position: Int): Any {
        return listWarung[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view = LayoutInflater.from(context)
            .inflate(R.layout.item_row_keranjang_warung, parent, false)

        val imgWarung = view.findViewById<ImageView>(R.id.imgWarungKeranjang)
        val tvNamaWarung = view.findViewById<TextView>(R.id.tvNamaWarungKeranjang)
        val tvPreviewMenu = view.findViewById<TextView>(R.id.tvPreviewMenu)

        val warung = listWarung[position]

        tvNamaWarung.text = warung.namaWarung

        // preview 3 menu pertama
        val previewMenu = warung.daftarMenu
            .take(3)
            .joinToString(", ") { it.namaMenu }

        tvPreviewMenu.text = previewMenu

        // set gambar warung sesuai nama
        imgWarung.setImageResource(getGambarWarung(warung.namaWarung))

        return view
    }

    private fun getGambarWarung(nama: String): Int {

        val n = nama.lowercase()

        return when {

            n.contains("heny") -> R.drawable.kantin_heny
            n.contains("arimby") -> R.drawable.kantin_arimby
            n.contains("prayata") -> R.drawable.prayata_resto
            n.contains("bu sri") -> R.drawable.warung_bu_sri
            n.contains("bang wahid") -> R.drawable.warung_bang_wahid
            n.contains("bu ghin") -> R.drawable.kantin_bu_ghin
            n.contains("berkah") -> R.drawable.warung_berkah
            n.contains("ex fk") -> R.drawable.kantin_ex_fk
            n.contains("ibu'is") -> R.drawable.kantin_ibu_is
            n.contains("pondok") -> R.drawable.pondok_kuliner_07
            n.contains("cindy") -> R.drawable.kantin_cindy
            n.contains("pak tris") -> R.drawable.kantin_pak_tris
            n.contains("titik") -> R.drawable.kantin_titik_18
            n.contains("bunda") -> R.drawable.kantin_bunda
            n.contains("dapur mamah") -> R.drawable.dapur_mamah

            else -> R.drawable.warung_placeholder
        }
    }
}