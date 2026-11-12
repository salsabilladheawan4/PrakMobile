package com.example.saturnus_salsa.message.tutorial

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.ImageView
import com.example.saturnus_salsa.R

class Tutorial3Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = LinearLayout(requireContext()).apply {
            orientation = LinearLayout.VERTICAL
            gravity = android.view.Gravity.CENTER
            setBackgroundColor(Color.parseColor("#26A69A"))
            setPadding(32, 32, 32, 32)
        }

        val imageView = ImageView(requireContext()).apply {
            setImageResource(R.mipmap.ic_launcher)
            layoutParams = LinearLayout.LayoutParams(200, 200).apply {
                bottomMargin = 48
            }
        }

        val title = TextView(requireContext()).apply {
            text = "Mulai Gunakan Sekarang"
            textSize = 22f
            setTextColor(Color.WHITE)
            setTypeface(null, android.graphics.Typeface.BOLD)
            gravity = android.view.Gravity.CENTER
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { bottomMargin = 16 }
        }

        val desc = TextView(requireContext()).apply {
            text = "Jelajahi fitur pesan dan temukan informasi penting dari pengguna lain. Fitur ini dirancang simpel, cepat, dan mudah dipahami."
            textSize = 14f
            setTextColor(Color.WHITE)
            gravity = android.view.Gravity.CENTER
        }

        view.addView(imageView)
        view.addView(title)
        view.addView(desc)

        return view
    }
}