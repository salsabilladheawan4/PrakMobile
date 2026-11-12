package com.example.saturnus_salsa.pertemuan_11

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView

class TabAFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val textView = TextView(requireContext()).apply {
            text = "Konten Tab A"
            textSize = 24f
            setTextColor(Color.parseColor("#2C3E2B")) // Deep Green Text
            gravity = android.view.Gravity.CENTER
        }
        return FrameLayout(requireContext()).apply {
            setBackgroundColor(Color.parseColor("#F6B8C3")) // Soft Blossom Pink (Matcha & Pink theme)
            addView(textView, FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            ))
        }
    }
}