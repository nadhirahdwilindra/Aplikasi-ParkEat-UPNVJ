package com.app.parkeatupnvj.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.app.parkeatupnvj.R
import com.app.parkeatupnvj.model.Menu

class MenuAdapter(
    private val context: Context,
    private val listMenu: List<Menu>
) : BaseAdapter() {

    override fun getCount(): Int {
        return listMenu.size
    }

    override fun getItem(position: Int): Any {
        return listMenu[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view = LayoutInflater.from(context)
            .inflate(R.layout.item_row_menu, parent, false)

        val imgMenu = view.findViewById<ImageView>(R.id.imgMenu)
        val tvNama = view.findViewById<TextView>(R.id.tvNamaMenu)
        val tvHarga = view.findViewById<TextView>(R.id.tvHargaMenu)

        val menu = listMenu[position]

        imgMenu.setImageResource(menu.gambar)
        tvNama.text = menu.nama
        tvHarga.text = menu.harga

        return view
    }
}