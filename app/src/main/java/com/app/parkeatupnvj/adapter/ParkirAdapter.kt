package com.app.parkeatupnvj.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.parkeatupnvj.R
import com.app.parkeatupnvj.model.Parkir

class ParkirAdapter(
    private val listParkir: ArrayList<Parkir>,
    private val layout: Int,
    private val onClick: (Parkir) -> Unit
) : RecyclerView.Adapter<ParkirAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgParkir: ImageView = itemView.findViewById(R.id.imgParkir)
        val tvNamaArea: TextView = itemView.findViewById(R.id.tvNamaArea)
        val tvMotor: TextView = itemView.findViewById(R.id.tvMotor)
        val tvMobil: TextView = itemView.findViewById(R.id.tvMobil)
        val tvStatus: TextView = itemView.findViewById(R.id.tvStatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(layout, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val parkir = listParkir[position]

        holder.imgParkir.setImageResource(parkir.gambar)
        holder.tvNamaArea.text = parkir.namaArea
        holder.tvMotor.text = "🚲 Motor : ${parkir.motor} Slot"
        holder.tvMobil.text = "🚗 Mobil : ${parkir.mobil} Slot"
        holder.tvStatus.text = "● ${parkir.status}"

        holder.itemView.setOnClickListener {
            onClick(parkir)
        }

        when (parkir.status) {
            "Tersedia" ->
                holder.tvStatus.setTextColor(Color.parseColor("#2E7D32"))

            "Hampir Penuh" ->
                holder.tvStatus.setTextColor(Color.parseColor("#F9A825"))

            "Penuh" ->
                holder.tvStatus.setTextColor(Color.parseColor("#C62828"))
        }
    }

    override fun getItemCount(): Int {
        return listParkir.size
    }
}