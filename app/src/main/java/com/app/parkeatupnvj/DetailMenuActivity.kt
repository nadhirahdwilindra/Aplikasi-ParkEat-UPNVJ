package com.app.parkeatupnvj

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.app.parkeatupnvj.model.CartItem
import com.app.parkeatupnvj.database.DatabaseKeranjang
import com.app.parkeatupnvj.repository.CartManager
import android.content.Intent

class DetailMenuActivity : AppCompatActivity() {

    var jumlah = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_menu)
        val dbKeranjang = DatabaseKeranjang(this)

        val imgMenu = findViewById<ImageView>(R.id.imgMenuDetail)
        val tvNama = findViewById<TextView>(R.id.tvNamaMenuDetail)
        val tvHarga = findViewById<TextView>(R.id.tvHargaMenuDetail)
        val tvDeskripsi = findViewById<TextView>(R.id.tvDeskripsiMenu)

        val btnPlus = findViewById<Button>(R.id.btnPlus)
        val btnMinus = findViewById<Button>(R.id.btnMinus)
        val tvJumlah = findViewById<TextView>(R.id.tvJumlah)
        val btnKeranjang = findViewById<Button>(R.id.btnKeranjang)

        val nama = intent.getStringExtra("NAMA_MENU")
        val harga = intent.getStringExtra("HARGA_MENU")
        val gambar = intent.getIntExtra("GAMBAR_MENU", 0)
        val namaWarung = intent.getStringExtra("NAMA_WARUNG")

        tvNama.text = nama
        tvHarga.text = harga
        tvDeskripsi.text = getDeskripsiMenu(nama)
        imgMenu.setImageResource(gambar)

        tvJumlah.text = jumlah.toString()

        btnPlus.setOnClickListener {
            jumlah++
            tvJumlah.text = jumlah.toString()
        }

        btnMinus.setOnClickListener {
            if (jumlah > 1) {
                jumlah--
                tvJumlah.text = jumlah.toString()
            }
        }

        btnKeranjang.setOnClickListener {

            val item = CartItem(
                namaMenu = nama ?: "",
                hargaMenu = harga ?: "",
                gambarMenu = gambar,
                jumlah = jumlah,
                namaWarung = namaWarung ?: ""
            )

            dbKeranjang.tambahKeKeranjang(item)

            Toast.makeText(this, "Menu ditambahkan ke keranjang", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, KeranjangActivity::class.java)
            startActivity(intent)
        }
    }

    fun getDeskripsiMenu(nama: String?): String {

        val n = nama?.lowercase() ?: ""

        return when {

            n.contains("americano") ->
                "Kopi hitam tanpa gula dengan rasa kuat dan aroma khas."

            n.contains("kopi") ->
                "Minuman kopi hangat atau dingin dengan aroma khas."

            n.contains("pop ice") ->
                "Minuman dingin manis dengan berbagai varian rasa."

            n.contains("nutrisari") ->
                "Minuman jeruk segar dengan rasa manis menyegarkan."

            n.contains("thai tea") ->
                "Teh susu khas Thailand dengan rasa manis creamy."

            n.contains("lemon tea") ->
                "Teh dengan campuran lemon segar yang menyegarkan."

            n.contains("jeruk") ->
                "Minuman jeruk segar dengan rasa asam manis."

            n.contains("milo") ->
                "Minuman coklat malt hangat atau dingin."

            n.contains("good day") ->
                "Minuman kopi instan dengan berbagai varian rasa."

            n.contains("es kelapa") ->
                "Minuman kelapa segar yang menyegarkan."

            n.contains("es teh") ->
                "Teh manis dingin yang menyegarkan."

            n.contains("air mineral") || n.contains("aqua") ->
                "Air mineral segar untuk melepas dahaga."

            n.contains("kebab") ->
                "Kebab isi daging dan sayuran dengan saus lezat."

            n.contains("burger") ->
                "Burger dengan roti lembut, daging, dan saus spesial."

            n.contains("takoyaki") ->
                "Bola tepung khas Jepang dengan isian gurita."

            n.contains("nasgor") ->
                "Nasi goreng telur dengan topping tambahan yang spesial."

            n.contains("dimsum") ->
                "Dimsum kukus gurih dengan tekstur lembut."

            n.contains("siomay") ->
                "Siomay ikan dengan saus kacang gurih."

            n.contains("batagor") ->
                "Bakso tahu goreng dengan saus kacang khas."

            n.contains("bakso") ->
                "Bakso kenyal dengan kuah kaldu gurih."

            n.contains("mie ayam") ->
                "Mie ayam dengan topping ayam gurih."

            n.contains("mie nyemek") ->
                "Mie dengan kuah kental gurih khas warung."

            n.contains("mie goreng") ->
                "Mie goreng dengan bumbu khas dan topping."

            n.contains("kwetiau") ->
                "Kwetiau goreng dengan bumbu khas."

            n.contains("indomie") ->
                "Indomie hangat dengan topping sesuai pilihan."

            n.contains("nasi goreng") ->
                "Nasi goreng dengan bumbu khas dan topping."

            n.contains("yamin") ->
                "Mie ayam dengan rasa mie yang manis menenangkan hati."

            n.contains("soto") ->
                "Soto ayam hangat dengan kuah gurih."

            n.contains("geprek") ->
                "Ayam goreng yang digeprek dengan sambal pedas."

            n.contains("penyet") ->
                "Ayam goreng yang dipenyet dengan sambal khas."

            n.contains("bakar") ->
                "Ayam bakar dengan bumbu khas dan aroma smokey."

            n.contains("rotbak") ->
                "Roti yang dibakar dengan penuh cinta."

            n.contains("pisbak") ->
                "Pisang yang dibakar dengan penuh cinta."

            n.contains(" ayam goreng") ->
                "Ayam goreng renyah dengan bumbu gurih."

            n.contains("sate") ->
                "Sate ayam dengan bumbu luar biasa."

            n.contains("taichan") ->
                "Sate taichan yang gurih dengan bumbu yang mantap."

            n.contains("teriyaki") ->
                "Daging dengan saus teriyaki manis gurih khas Jepang."

            n.contains("karage") ->
                "Ayam goreng Jepang dengan tepung renyah."

            n.contains("bento") ->
                "Paket nasi lengkap dengan lauk khas Jepang."

            n.contains("pisang") ->
                "Pisang bakar manis dengan topping lezat."

            n.contains("roti bakar") ->
                "Roti bakar hangat dengan topping manis."

            n.contains("pancong") ->
                "Kue pancong lembut dengan topping manis."

            n.contains("lumpia") ->
                "Lumpia goreng dengan isi gurih."

            n.contains("gorengan") ->
                "Gorengan renyah cocok untuk camilan."

            n.contains("mendoan") ->
                "Tempe mendoan goreng dengan tepung gurih."

            n.contains("gado") ->
                "Sayuran segar dengan saus kacang khas."

            n.contains("ketoprak") ->
                "Ketoprak dengan lontong, tahu, dan saus kacang."

            n.contains("karedok") ->
                "Sayuran mentah dengan saus kacang khas Sunda."

            else ->
                "Menu favorit yang dimasak fresh setiap hari."
        }
    }
}