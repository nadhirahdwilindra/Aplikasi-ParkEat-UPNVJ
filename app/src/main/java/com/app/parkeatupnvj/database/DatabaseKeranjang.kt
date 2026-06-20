package com.app.parkeatupnvj.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.app.parkeatupnvj.model.CartItem

class DatabaseKeranjang(context: Context) :
    SQLiteOpenHelper(context, "KeranjangDB", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {

        val createTable = "CREATE TABLE cart (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nama_warung TEXT," +
                "nama_menu TEXT," +
                "harga_menu TEXT," +
                "gambar_menu INTEGER," +
                "jumlah INTEGER)"

        db?.execSQL(createTable)
    }

    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {
        db?.execSQL("DROP TABLE IF EXISTS cart")
        onCreate(db)
    }

    fun tambahKeKeranjang(item: CartItem) {

        val db = writableDatabase

        // cek apakah menu sudah ada
        val cursor = db.rawQuery(
            "SELECT jumlah FROM cart WHERE nama_menu=?",
            arrayOf(item.namaMenu)
        )

        if (cursor.moveToFirst()) {

            val jumlahLama = cursor.getInt(0)
            val jumlahBaru = jumlahLama + item.jumlah

            val values = ContentValues()
            values.put("jumlah", jumlahBaru)

            db.update(
                "cart",
                values,
                "nama_menu=?",
                arrayOf(item.namaMenu)
            )

        } else {

            val values = ContentValues()

            values.put("nama_warung", item.namaWarung)
            values.put("nama_menu", item.namaMenu)
            values.put("harga_menu", item.hargaMenu)
            values.put("gambar_menu", item.gambarMenu)
            values.put("jumlah", item.jumlah)

            db.insert("cart", null, values)
        }

        cursor.close()
    }

    fun getSemuaKeranjang(): ArrayList<CartItem> {

        val list = ArrayList<CartItem>()
        val db = readableDatabase

        val cursor = db.rawQuery(
            "SELECT * FROM cart",
            null
        )

        if (cursor.moveToFirst()) {

            do {

                val item = CartItem(
                    namaWarung = cursor.getString(1),
                    namaMenu = cursor.getString(2),
                    hargaMenu = cursor.getString(3),
                    gambarMenu = cursor.getInt(4),
                    jumlah = cursor.getInt(5)
                )

                list.add(item)

            } while (cursor.moveToNext())
        }

        cursor.close()
        return list
    }

    fun hapusItem(namaMenu: String) {

        val db = writableDatabase

        db.delete(
            "cart",
            "nama_menu=?",
            arrayOf(namaMenu)
        )
    }

    fun hapusWarung(namaWarung: String) {

        val db = writableDatabase

        db.delete(
            "cart",
            "nama_warung=?",
            arrayOf(namaWarung)
        )
    }

    fun kosongkanKeranjang() {

        val db = writableDatabase

        db.delete(
            "cart",
            null,
            null
        )
    }
}