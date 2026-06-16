package com.app.parkeatupnvj.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.app.parkeatupnvj.R
import com.app.parkeatupnvj.model.Warung

class WarungAdapter(
    private val context: Context,
    private val listWarung: List<Warung>
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
            .inflate(R.layout.item_row_warung, parent, false)

        val imgWarung = view.findViewById<ImageView>(R.id.imgWarung)
        val tvNama = view.findViewById<TextView>(R.id.tvNamaWarung)
        val tvDeskripsi = view.findViewById<TextView>(R.id.tvDeskripsi)

        val warung = listWarung[position]

        imgWarung.setImageResource(warung.gambar)
        tvNama.text = warung.nama
        tvDeskripsi.text = warung.deskripsi

        return view
    }
}