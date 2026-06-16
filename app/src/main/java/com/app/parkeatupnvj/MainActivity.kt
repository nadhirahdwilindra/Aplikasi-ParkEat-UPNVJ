package com.app.parkeatupnvj

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNim = findViewById<EditText>(R.id.etNim)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {

            val nim = etNim.text.toString()
            val password = etPassword.text.toString()

            if (nim.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Mohon Lengkapi NIM dan Password", Toast.LENGTH_SHORT).show()
            } else {

                val intent = Intent(this, HomeActivity::class.java)

                intent.putExtra("NAMA_USER", "Nadhirah")

                startActivity(intent)
            }
        }
    }
}