package com.example.tugas5_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tugas5_fragment.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set data dinamis pada tampilan
        binding.tvUsername.text = "Budi Santoso"
        binding.tvStatOrders.text = "5"
        binding.tvStatWishlist.text = "12"
        binding.tvStatCart.text = "3"

        // Navigasi ke fragment Produk saat klik kategori Elektronik
        binding.cardElektronik.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, ProductsFragment())
                .addToBackStack(null)
                .commit()
        }

        // Navigasi ke fragment Produk saat klik kategori Fashion
        binding.cardFashion.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, ProductsFragment())
                .addToBackStack(null)
                .commit()
        }

        // Navigasi ke fragment Produk saat klik kategori Makanan
        binding.cardMakanan.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, ProductsFragment())
                .addToBackStack(null)
                .commit()
        }

        // Navigasi ke fragment Produk saat klik kategori Lainnya
        binding.cardLainnya.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, ProductsFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    // Wajib: bebaskan binding saat view dihancurkan agar tidak memory leak
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
