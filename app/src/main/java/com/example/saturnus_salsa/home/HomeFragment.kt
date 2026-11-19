package com.example.saturnus_salsa.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.saturnus_salsa.AuthActivity
import com.example.saturnus_salsa.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.saturnus_salsa.home.data.api.CatFactApiClient
import com.example.saturnus_salsa.home.photo.PhotoApiClient
import com.example.saturnus_salsa.home.photo.PhotoAdapter
import android.widget.Toast
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set Toolbar sebagai action bar untuk activity ini
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Home"
        }

        binding.btnToFourth.setOnClickListener {
            Log.d("HomeFragment", "btnToFourth clicked")
            val intent = Intent(requireContext(), com.example.saturnus_salsa.pertemuan_4.FourthActivity::class.java)
            intent.putExtra("name", "Politeknik Caltex Riau")
            intent.putExtra("from", "Rumbai")
            intent.putExtra("age", 25)
            startActivity(intent)
        }

        binding.btnToFifth.setOnClickListener {
            startActivity(Intent(requireContext(), com.example.saturnus_salsa.pertemuan_5.FifthActivity::class.java))
        }

        binding.btnToSixth.setOnClickListener {
            startActivity(Intent(requireContext(), com.example.saturnus_salsa.pertemuan_6.SixthActivity::class.java))
        }

        binding.btnToSeventh.setOnClickListener {
            startActivity(Intent(requireContext(), com.example.saturnus_salsa.pertemuan_7.SeventhActivity::class.java))
        }

        binding.btnToTenth.setOnClickListener {
            startActivity(Intent(requireContext(), com.example.saturnus_salsa.pertemuan_10.TenthActivity::class.java))
        }

        binding.btnLogout.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Konfirmasi Logout")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya") { dialog, _ ->
                    val sharedPref = requireActivity().getSharedPreferences("user_pref", Context.MODE_PRIVATE)
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()
                    dialog.dismiss()
                    
                    val intent = Intent(requireContext(), AuthActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    requireActivity().finish()
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }

        loadCatFact()

        binding.btnRefresh.setOnClickListener {
            binding.tvCatFact.text = "Loading cat fact..."
            loadCatFact()
        }

        loadPhoto()
    }

    private fun loadCatFact() {
        lifecycleScope.launch {
            try {
                val response = CatFactApiClient.apiService.getCatFact()
                binding.tvCatFact.text = "\"${response.fact}\""
            } catch (e: Exception) {
                binding.tvCatFact.text = "Gagal mengambil fakta kucing."
            }
        }
    }

    private fun loadPhoto() {
        lifecycleScope.launch {
            try {
                val photos = PhotoApiClient.apiService.getPhotos()
                val adapter = PhotoAdapter(photos)
                binding.rvGallery.adapter = adapter
                binding.rvGallery.layoutManager = LinearLayoutManager(requireContext())
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Gagal memuat gambar", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}