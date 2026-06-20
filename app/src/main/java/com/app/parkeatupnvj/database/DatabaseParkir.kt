package com.app.parkeatupnvj.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.app.parkeatupnvj.model.Parkir

class DatabaseParkir(context: Context) :
    SQLiteOpenHelper(context, "ParkEatDB", null, 2) {

    override fun onCreate(db: SQLiteDatabase?) {

        val createTable = "CREATE TABLE parkir (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nama_area TEXT," +
                "slot_motor INTEGER," +
                "slot_mobil INTEGER," +
                "max_motor INTEGER," +
                "max_mobil INTEGER," +
                "status TEXT," +
                "gambar INTEGER)"

        db?.execSQL(createTable)

        insertDataAwal(db)
    }

    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {
        db?.execSQL("DROP TABLE IF EXISTS parkir")
        onCreate(db)
    }

    private fun insertDataAwal(db: SQLiteDatabase?) {

        tambahParkir(db, "Area Parkir FEB", 42, 10, 42, 10, "Tersedia")

        tambahParkir(db, "Area Parkir Hukum", 18, 4, 18, 4, "Tersedia")

        tambahParkir(db, "Area Parkir Rektorat", 0, 0, 15, 5, "Penuh")

        tambahParkir(db, "Area Parkir FIK", 25, 8, 25, 8, "Tersedia")

        tambahParkir(db, "Area Parkir FISIP", 35, 7, 35, 7, "Tersedia")

        tambahParkir(db, "Area Parkir APU", 12, 2, 12, 2, "Tersedia")

        tambahParkir(db, "Area Parkir Kantin", 8, 1, 8, 1, "Tersedia")
    }

    private fun tambahParkir(
        db: SQLiteDatabase?,
        nama: String,
        motor: Int,
        mobil: Int,
        maxMotor: Int,
        maxMobil: Int,
        status: String
    ) {

        val values = ContentValues()

        values.put("nama_area", nama)
        values.put("slot_motor", motor)
        values.put("slot_mobil", mobil)
        values.put("max_motor", maxMotor)
        values.put("max_mobil", maxMobil)
        values.put("status", status)
        values.put("gambar", 0)

        db?.insert("parkir", null, values)
    }

    fun getAllParkir(): ArrayList<Parkir> {

        val list = ArrayList<Parkir>()

        val db = readableDatabase

        val cursor = db.rawQuery("SELECT * FROM parkir", null)

        if (cursor.moveToFirst()) {

            do {

                val parkir = Parkir(
                    cursor.getString(1),
                    cursor.getInt(2),
                    cursor.getInt(3),
                    cursor.getString(6),
                    0
                )

                list.add(parkir)

            } while (cursor.moveToNext())
        }

        cursor.close()

        return list
    }

    fun kurangiSlot(
        namaArea: String,
        jenisKendaraan: String
    ) {

        val db = writableDatabase

        if (jenisKendaraan == "Motor") {

            db.execSQL(
                "UPDATE parkir SET slot_motor = slot_motor - 1 " +
                        "WHERE nama_area = '$namaArea' AND slot_motor > 0"
            )

        } else {

            db.execSQL(
                "UPDATE parkir SET slot_mobil = slot_mobil - 1 " +
                        "WHERE nama_area = '$namaArea' AND slot_mobil > 0"
            )
        }

        // update status setelah slot berubah
        updateStatus(namaArea)
    }

    private fun updateStatus(namaArea: String) {

        val db = readableDatabase

        val cursor = db.rawQuery(
            "SELECT slot_motor, slot_mobil, max_motor, max_mobil FROM parkir WHERE nama_area = ?",
            arrayOf(namaArea)
        )

        if (cursor.moveToFirst()) {

            val slotMotor = cursor.getInt(0)
            val slotMobil = cursor.getInt(1)
            val maxMotor = cursor.getInt(2)
            val maxMobil = cursor.getInt(3)

            val totalSisa = slotMotor + slotMobil
            val totalMax = maxMotor + maxMobil

            val persen = (totalSisa.toDouble() / totalMax.toDouble()) * 100

            val statusBaru = when {

                totalSisa == 0 -> "Penuh"

                persen <= 30 -> "Hampir Penuh"

                else -> "Tersedia"
            }

            val dbUpdate = writableDatabase

            dbUpdate.execSQL(
                "UPDATE parkir SET status = '$statusBaru' WHERE nama_area = '$namaArea'"
            )
        }

        cursor.close()
    }

    fun cekSlotTersedia(
        namaArea: String,
        jenisKendaraan: String
    ): Boolean {

        val db = readableDatabase

        val cursor = if (jenisKendaraan == "Motor") {

            db.rawQuery(
                "SELECT slot_motor FROM parkir WHERE nama_area = ?",
                arrayOf(namaArea)
            )

        } else {

            db.rawQuery(
                "SELECT slot_mobil FROM parkir WHERE nama_area = ?",
                arrayOf(namaArea)
            )
        }

        var tersedia = false

        if (cursor.moveToFirst()) {

            val slot = cursor.getInt(0)

            tersedia = slot > 0
        }

        cursor.close()

        return tersedia
    }

}