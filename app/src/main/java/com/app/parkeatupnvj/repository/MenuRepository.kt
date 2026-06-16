package com.app.parkeatupnvj.repository

import com.app.parkeatupnvj.R
import com.app.parkeatupnvj.model.Menu

object MenuRepository {

    fun getMenuByWarung(namaWarung: String?): List<Menu> {

        return when (namaWarung) {

            // KANTIN HENY
            "Kantin Heny" -> listOf(
                Menu("Kebab", "Rp10000", R.drawable.kebab),
                Menu("PisBak", "Rp8000", R.drawable.pisang_bakar),
                Menu("RotBak", "Rp6000", R.drawable.roti_bakar),
                Menu("Mie Wonton Chili Oil", "Rp12000", R.drawable.mie_wonton),
                Menu("Wonton Chili Oil", "Rp10000", R.drawable.wonton),
                Menu("Mie Nyemek", "Rp12000", R.drawable.mie_nyemek),
                Menu("Lumpia Beef Patties", "Rp6000", R.drawable.lumpia),
                Menu("Baso Aci", "Rp12000", R.drawable.baso_aci),
                Menu("Indomie Telur Double", "Rp15000", R.drawable.indomie),
                Menu("Indomie Double", "Rp11000", R.drawable.indomie),
                Menu("Es Teh Manis", "Rp3000", R.drawable.es_teh),
                Menu("Es Kopi", "Rp5000", R.drawable.es_kopi),
                Menu("Pop Ice", "Rp5000", R.drawable.pop_ice),
                Menu("Nutrisari", "Rp5000", R.drawable.nutrisari),
                Menu("Es Kul Kul", "Rp5000", R.drawable.es_kelapa)
            )

            // ARIMBY
            "Kantin Arimby" -> listOf(
                Menu("Nasi Ayam Bakar", "Rp20000", R.drawable.ayam_bakar),
                Menu("Nasi Ayam Bakar Hemat", "Rp15000", R.drawable.ayam_bakar),
                Menu("Nasi Ayam Penyet", "Rp15000", R.drawable.ayam_penyet),
                Menu("Pecel Ayam", "Rp15000", R.drawable.pecel_ayam),
                Menu("Nasi Ayam Geprek", "Rp15000", R.drawable.ayam_geprek),
                Menu("Nasi Soto", "Rp15000", R.drawable.soto_ayam),
                Menu("Aneka Indomie", "Rp10000", R.drawable.indomie),
                Menu("Es Teh", "Rp5000", R.drawable.es_teh),
                Menu("Teh Hangat", "Rp3000", R.drawable.es_teh),
                Menu("Es Jeruk Peras", "Rp8000", R.drawable.es_jeruk),
                Menu("Aqua Botol", "Rp3000", R.drawable.air_mineral)
            )

            // PRAYATA
            "Prayata Resto" -> listOf(
                Menu("Nasi Rames", "Rp12000", R.drawable.nasi_rames),
                Menu("Nasi Ayam Bakar", "Rp15000", R.drawable.ayam_bakar),
                Menu("Takoyaki", "Rp13000", R.drawable.takoyaki),
                Menu("Nasi Ayam Goreng", "Rp15000", R.drawable.ayam_goreng),
                Menu("Nasi Ayam Geprek", "Rp15000", R.drawable.ayam_geprek),
                Menu("Milo", "Rp5000", R.drawable.milo),
                Menu("Good Day", "Rp5000", R.drawable.goodday),
                Menu("Nutrisari", "Rp5000", R.drawable.nutrisari)
            )

            // BU SRI
            "Warung Bu Sri" -> listOf(
                Menu("Mie Ayam", "Rp13000", R.drawable.mie_ayam),
                Menu("Mie Ayam Ceker", "Rp15000", R.drawable.mie_ayam),
                Menu("Mie Ayam Bakso", "Rp15000", R.drawable.mie_ayam),
                Menu("Pecel Ayam", "Rp15000", R.drawable.pecel_ayam),
                Menu("Mie Nyemek", "Rp15000", R.drawable.mie_nyemek),
                Menu("Nasi Goreng Telur", "Rp12000", R.drawable.nasi_goreng),
                Menu("Nasgor Telur + Bakso", "Rp15000", R.drawable.nasi_goreng),
                Menu("Nasgor Telur + Sosis", "Rp15000", R.drawable.nasi_goreng),
                Menu("Es Teh Solo", "Rp5000", R.drawable.es_teh),
                Menu("Thai Tea", "Rp10000", R.drawable.thai_tea),
                Menu("Lemon Tea", "Rp8000", R.drawable.lemon_tea),
                Menu("Jeruk Peras", "Rp8000", R.drawable.es_jeruk),
                Menu("Air Mineral", "Rp3000", R.drawable.air_mineral)
            )

            // BANG WAHID
            "Warung Bang Wahid" -> listOf(
                Menu("Burger", "Rp12000", R.drawable.burger),
                Menu("French Fries", "Rp8000", R.drawable.french_fries),
                Menu("Pancong Lumer", "Rp8000", R.drawable.pancong),
                Menu("Steak Chicken Crispy + Nasi", "Rp18000", R.drawable.steak_chicken),
                Menu("Steak Chicken Crispy + Kentang", "Rp20000", R.drawable.steak_chicken),
                Menu("Ayam Lumer BBQ", "Rp14000", R.drawable.ayam_goreng),
                Menu("Kwetiau Goreng", "Rp15000", R.drawable.kwetiau_goreng),
                Menu("Es Kopi Latte", "Rp12000", R.drawable.es_kopi),
                Menu("Americano", "Rp8000", R.drawable.kopi),
                Menu("Es Teh Jumbo", "Rp4000", R.drawable.es_teh)
            )

            // BU GHIN
            "Kantin Bu Ghin" -> listOf(
                Menu("Taichan", "Rp20000", R.drawable.sate_taichan),
                Menu("Cordon Bleu", "Rp20000", R.drawable.cordon_bleu),
                Menu("Bakso Urat", "Rp15000", R.drawable.bakso),
                Menu("Bakso Urat Telur", "Rp20000", R.drawable.bakso),
                Menu("Mie Nyemek", "Rp15000", R.drawable.mie_nyemek),
                Menu("Nasi Ayam Bakar", "Rp15000", R.drawable.ayam_bakar),
                Menu("Air Mineral", "Rp3000", R.drawable.air_mineral)
            )

            // BERKAH
            "Warung Berkah" -> listOf(
                Menu("Nasi Ayam Geprek", "Rp15000", R.drawable.ayam_geprek),
                Menu("Nasi Kulit Crispy", "Rp13000", R.drawable.kulit_crispy),
                Menu("Siomay Batagor", "Rp10000", R.drawable.siomay),
                Menu("Bakwan Malang", "Rp12000", R.drawable.bakwan_malang),
                Menu("Pangsit Rebus", "Rp12000", R.drawable.pangsit),
                Menu("Mie Ayam Yamin", "Rp12000", R.drawable.mie_ayam_yamin),
                Menu("Mineral", "Rp3000", R.drawable.air_mineral)
            )

            // EX FK
            "Kantin Ex FK" -> listOf(
                Menu("Nasi Ayam Geprek", "Rp15000", R.drawable.ayam_geprek),
                Menu("Nasi Goreng", "Rp15000", R.drawable.nasi_goreng),
                Menu("Soto Ayam", "Rp15000", R.drawable.soto_ayam),
                Menu("Beef Teriyaki", "Rp18000", R.drawable.ayam_teriyaki),
                Menu("Aneka Kopi", "Rp5000", R.drawable.kopi),
                Menu("Aneka Susu", "Rp6000", R.drawable.susu),
                Menu("Nutrisari", "Rp5000", R.drawable.nutrisari)
            )

            // IBU IS
            "Kantin Ibu is" -> listOf(
                Menu("Takoyaki", "Rp13000", R.drawable.takoyaki),
                Menu("Chicken Teriyaki", "Rp15000", R.drawable.ayam_teriyaki),
                Menu("Beef Teriyaki", "Rp18000", R.drawable.ayam_teriyaki),
                Menu("Bento 1", "Rp18000", R.drawable.bento),
                Menu("Bento 2", "Rp20000", R.drawable.bento),
                Menu("Bento 3", "Rp22000", R.drawable.bento),
                Menu("Pop Ice", "Rp5000", R.drawable.pop_ice),
                Menu("Aneka Kopi", "Rp5000", R.drawable.kopi),
                Menu("Air Mineral", "Rp3000", R.drawable.air_mineral)
            )

            // PONDOK KULINER
            "Pondok Kuliner 07" -> listOf(
                Menu("Ayam Penyet", "Rp15000", R.drawable.ayam_penyet),
                Menu("Taichan + Nasi", "Rp20000", R.drawable.sate_taichan),
                Menu("Dimsum", "Rp13000", R.drawable.dimsum),
                Menu("Mie Goreng Tektek", "Rp15000", R.drawable.mie_goreng),
                Menu("Mie Nyemek Mewek", "Rp15000", R.drawable.mie_nyemek),
                Menu("Es Teh Tarik", "Rp5000", R.drawable.es_teh),
                Menu("Es Kopi", "Rp4000", R.drawable.es_kopi),
                Menu("Es Teh Manis", "Rp5000", R.drawable.es_teh)
            )

            // CINDY
            "Kantin Cindy" -> listOf(
                Menu("Pecel Ayam", "Rp15000", R.drawable.pecel_ayam),
                Menu("Ayam Geprek", "Rp15000", R.drawable.ayam_geprek),
                Menu("Ayam Bakar", "Rp15000", R.drawable.ayam_bakar),
                Menu("Soto Ayam", "Rp15000", R.drawable.soto_ayam),
                Menu("Pop Ice", "Rp5000", R.drawable.pop_ice),
                Menu("Nutrisari", "Rp5000", R.drawable.nutrisari),
                Menu("Gorengan", "Rp2000", R.drawable.gorengan)
            )

            // PAK TRIS
            "Kantin Pak Tris" -> listOf(
                Menu("Mie Ayam Pangsit", "Rp14000", R.drawable.mie_ayam),
                Menu("Gado Gado", "Rp16000", R.drawable.gado_gado),
                Menu("Ketoprak", "Rp16000", R.drawable.ketoprak),
                Menu("Karedok", "Rp15000", R.drawable.karedok),
                Menu("Bakso Halus", "Rp13000", R.drawable.bakso),
                Menu("Bakso Telor", "Rp16000", R.drawable.bakso),
                Menu("Air Mineral", "Rp3000", R.drawable.air_mineral),
                Menu("Es Jeruk", "Rp5000", R.drawable.es_jeruk),
                Menu("Es Teh Manis", "Rp4000", R.drawable.es_teh)
            )

            // TITIK 18
            "Kantin Titik 18" -> listOf(
                Menu("Kwetiau Goreng", "Rp11000", R.drawable.kwetiau_goreng),
                Menu("Soto Ayam", "Rp15000", R.drawable.soto_ayam),
                Menu("Siomay", "Rp12000", R.drawable.siomay),
                Menu("Indomie Komplit", "Rp12000", R.drawable.indomie),
                Menu("Indomie Polos", "Rp6000", R.drawable.indomie),
                Menu("Ayam Goreng Sambel Korek", "Rp20000", R.drawable.ayam_goreng),
                Menu("Pop Ice", "Rp5000", R.drawable.pop_ice),
                Menu("Jus Buah", "Rp10000", R.drawable.jus_buah)
            )

            // BUNDA
            "Kantin Bunda" -> listOf(
                Menu("Nasi Ayam Karage", "Rp13000", R.drawable.ayam_karage),
                Menu("Nasi Ayam Geprek", "Rp15000", R.drawable.ayam_geprek),
                Menu("Nasi Ayam Penyet", "Rp15000", R.drawable.ayam_penyet),
                Menu("Nasi Ayam Bakar", "Rp15000", R.drawable.ayam_bakar),
                Menu("Nasi Goreng", "Rp15000", R.drawable.nasi_goreng),
                Menu("Soto Ayam + Nasi", "Rp15000", R.drawable.soto_ayam),
                Menu("Gorengan", "Rp2000", R.drawable.gorengan),
                Menu("Pop Ice", "Rp5000", R.drawable.pop_ice)
            )

            // DAPUR MAMAH
            "Dapur Mamah" -> listOf(
                Menu("Mendoan", "Rp3000", R.drawable.mendoan),
                Menu("Aneka Indomie", "Rp7000", R.drawable.indomie),
                Menu("Beef Teriyaki", "Rp18000", R.drawable.ayam_teriyaki),
                Menu("Ketoprak Telor", "Rp15000", R.drawable.ketoprak),
                Menu("Es Kelapa", "Rp5000", R.drawable.es_kelapa),
                Menu("Es Teh Manis", "Rp3000", R.drawable.es_teh),
                Menu("Air Mineral", "Rp4000", R.drawable.air_mineral),
                Menu("Nutrisari", "Rp4000", R.drawable.nutrisari),
                Menu("Aneka Kopi", "Rp5000", R.drawable.kopi)
            )

            else -> listOf()
        }
    }
}