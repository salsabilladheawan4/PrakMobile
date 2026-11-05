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

    // Avatar karakter imut dengan background nuansa pink pastel
    private val messageList = listOf(
        MessageModel("Alya", "Halo! Apa kabar?", "https://api.dicebear.com/7.x/lorelei/png?seed=Alya&backgroundColor=ffd1dc", "25"),
        MessageModel("Budi", "Sudah makan?", "https://api.dicebear.com/7.x/lorelei/png?seed=Budi&backgroundColor=ffb6c1", "25"),
        MessageModel("Citra", "Jangan lupa tugasnya ya!", "https://api.dicebear.com/7.x/lorelei/png?seed=Citra&backgroundColor=f472b6", "25"),
        MessageModel("Dika", "Besok kita rapat jam 9", "https://api.dicebear.com/7.x/lorelei/png?seed=Dika&backgroundColor=ffd1dc", "25"),
        MessageModel("Eka", "Nice job kemarin!", "https://api.dicebear.com/7.x/lorelei/png?seed=Eka&backgroundColor=ffb6c1", "25"),
        MessageModel("Fajar", "Lagi ngapain?", "https://api.dicebear.com/7.x/lorelei/png?seed=Fajar&backgroundColor=f472b6", "25"),
        MessageModel("Gita", "Boleh minta tolong?", "https://api.dicebear.com/7.x/lorelei/png?seed=Gita&backgroundColor=ffd1dc", "25"),
        MessageModel("Hana", "Lihat email ya", "https://api.dicebear.com/7.x/lorelei/png?seed=Hana&backgroundColor=ffb6c1", "25"),
        MessageModel("Irfan", "Oke noted", "https://api.dicebear.com/7.x/lorelei/png?seed=Irfan&backgroundColor=f472b6", "25"),
        MessageModel("Joko", "Sampai jumpa besok", "https://api.dicebear.com/7.x/lorelei/png?seed=Joko&backgroundColor=ffd1dc", "25")
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

        // Pasang MessageAdapter ke ListView
        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItems.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}