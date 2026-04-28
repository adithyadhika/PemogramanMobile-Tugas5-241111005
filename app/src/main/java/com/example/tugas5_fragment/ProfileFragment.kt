package com.example.tugas5_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tugas5_fragment.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set data profil pengguna secara dinamis
        binding.tvProfileName.text  = "Budi Santoso"
        binding.tvProfileEmail.text = "budi@example.com"
        binding.tvInfoName.text     = "Budi Santoso"
        binding.tvInfoEmail.text    = "budi@example.com"
        binding.tvInfoPhone.text    = "+62 812-3456-7890"
        binding.tvInfoAddress.text  = "Jl. Merdeka No. 10, Bandung"

        // Set statistik belanja
        binding.tvCountOrders.text   = "5"
        binding.tvCountWishlist.text = "12"
        binding.tvCountReviews.text  = "8"

        // Tombol Edit Profil
        binding.btnEditProfile.setOnClickListener {
            Toast.makeText(requireContext(), "Fitur edit profil segera hadir!", Toast.LENGTH_SHORT).show()
        }

        // Tombol Logout
        binding.btnLogout.setOnClickListener {
            Toast.makeText(requireContext(), "Berhasil keluar dari akun", Toast.LENGTH_SHORT).show()
            // Tambahkan navigasi ke LoginActivity jika ada:
            // val intent = Intent(requireContext(), LoginActivity::class.java)
            // startActivity(intent)
            // requireActivity().finish()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
