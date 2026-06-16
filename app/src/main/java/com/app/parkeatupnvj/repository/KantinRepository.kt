package com.app.parkeatupnvj.repository

import com.app.parkeatupnvj.R
import com.app.parkeatupnvj.model.Warung

object KantinRepository {

    fun getWarungList(): List<Warung> {
        return listOf(

            Warung(
                "Kantin Heny",
                "Menyediakan berbagai makanan rumahan dan minuman segar",
                R.drawable.kantin_heny
            ),

            Warung(
                "Kantin Arimby",
                "Menu nasi, lauk pauk dan minuman dingin",
                R.drawable.kantin_arimby
            ),

            Warung(
                "Prayata Resto",
                "Berbagai menu makanan berat dan minuman",
                R.drawable.prayata_resto
            ),

            Warung(
                "Warung Bu Sri",
                "Menyediakan nasi, mie dan berbagai lauk",
                R.drawable.warung_bu_sri
            ),

            Warung(
                "Warung Bang Wahid",
                "Menu makanan sederhana dan minuman segar",
                R.drawable.warung_bang_wahid
            ),

            Warung(
                "Kantin Bu Ghin",
                "Berbagai menu makanan kampus favorit mahasiswa",
                R.drawable.kantin_bu_ghin
            ),

            Warung(
                "Warung Berkah",
                "Menyediakan makanan berat dan minuman",
                R.drawable.warung_berkah
            ),

            Warung(
                "Kantin Ex FK",
                "Menu nasi dan lauk dengan harga terjangkau",
                R.drawable.kantin_ex_fk
            ),

            Warung(
                "Kantin Ibu Is",
                "Makanan rumahan dan minuman dingin",
                R.drawable.kantin_ibu_is
            ),

            Warung(
                "Pondok Kuliner 07",
                "Aneka makanan dan minuman mahasiswa",
                R.drawable.pondok_kuliner_07
            ),

            Warung(
                "Kantin Cindy",
                "Menu makanan cepat saji dan minuman",
                R.drawable.kantin_cindy
            ),

            Warung(
                "Kantin Pak Tris",
                "Menyediakan makanan berat dan minuman segar",
                R.drawable.kantin_pak_tris
            ),

            Warung(
                "Kantin Titik 18",
                "Berbagai pilihan menu makanan kampus",
                R.drawable.kantin_titik_18
            ),

            Warung(
                "Kantin Bunda",
                "Makanan rumahan dengan berbagai lauk",
                R.drawable.kantin_bunda
            ),

            Warung(
                "Dapur Mamah",
                "Menu makanan rumahan favorit mahasiswa",
                R.drawable.dapur_mamah
            )

        )
    }

}