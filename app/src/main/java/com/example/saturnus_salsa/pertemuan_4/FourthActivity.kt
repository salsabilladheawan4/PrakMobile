package com.example.saturnus_salsa.pertemuan_4

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.saturnus_salsa.R
import com.google.android.material.snackbar.Snackbar

class FourthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fourth)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.title = "Pertemuan 4"
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val btnShowAlertDialog = findViewById<Button>(R.id.btnShowAlertDialog)
        val btnShowSnackbar = findViewById<Button>(R.id.btnShowSnackbar)
        val btnKembali = findViewById<Button>(R.id.btnKembali)

        btnShowAlertDialog.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Alert Dialog")
                .setMessage("Ini adalah contoh AlertDialog pada Pertemuan 4")
                .setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }

        btnShowSnackbar.setOnClickListener {
            Snackbar.make(it, "Ini adalah contoh Snackbar", Snackbar.LENGTH_SHORT).show()
        }

        btnKembali.setOnClickListener {
            finish()
        }
    }
}