package com.example.saturnus_salsa.message

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.saturnus_salsa.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {
    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    // Avatar karakter ilustrasi estetik & lucu (DiceBear Lorelei)
    private val messageList = listOf(
        MessageModel("Alya", "Halo! Apa kabar?", "https://api.dicebear.com/7.x/lorelei/png?seed=Alya", "09:41"),
        MessageModel("Budi", "Sudah makan?", "https://api.dicebear.com/7.x/lorelei/png?seed=Budi", "09:15"),
        MessageModel("Citra", "Jangan lupa tugasnya ya!", "https://api.dicebear.com/7.x/lorelei/png?seed=Citra", "Kemarin"),
        MessageModel("Dika", "Besok kita rapat jam 9", "https://api.dicebear.com/7.x/lorelei/png?seed=Dika", "Kemarin"),
        MessageModel("Eka", "Nice job kemarin!", "https://api.dicebear.com/7.x/lorelei/png?seed=Eka", "2 Hari lalu"),
        MessageModel("Fajar", "Lagi ngapain?", "https://api.dicebear.com/7.x/lorelei/png?seed=Fajar", "2 Hari lalu"),
        MessageModel("Gita", "Boleh minta tolong?", "https://api.dicebear.com/7.x/lorelei/png?seed=Gita", "3 Hari lalu"),
        MessageModel("Hana", "Lihat email ya", "https://api.dicebear.com/7.x/lorelei/png?seed=Hana", "3 Hari lalu")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Message"
        }

        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItems.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}