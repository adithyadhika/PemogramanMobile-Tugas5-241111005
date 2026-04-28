package com.example.tugas5_fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugas5_fragment.databinding.FragmentProductsBinding

class ProductsFragment : Fragment() {

    private var _binding: FragmentProductsBinding? = null
    private val binding get() = _binding!!

    // Data dummy produk untuk ditampilkan
    private val allProducts = listOf(
        Product(1, "Samsung Galaxy A55",    "Elektronik", "Rp 4.999.000",  "📱"),
        Product(2, "Laptop ASUS VivoBook",  "Elektronik", "Rp 8.500.000",  "💻"),
        Product(3, "Kaos Polos Premium",    "Fashion",    "Rp 89.000",     "👕"),
        Product(4, "Sepatu Sneakers Pria",  "Fashion",    "Rp 350.000",    "👟"),
        Product(5, "Paket Nasi Goreng",     "Makanan",    "Rp 25.000",     "🍳"),
        Product(6, "Kopi Arabika 500gr",    "Makanan",    "Rp 75.000",     "☕"),
        Product(7, "Tas Ransel Kulit",      "Fashion",    "Rp 280.000",    "🎒"),
        Product(8, "Headphone Bluetooth",   "Elektronik", "Rp 450.000",    "🎧"),
        Product(9, "Mie Instan Kotak 40pcs","Makanan",    "Rp 95.000",     "🍜"),
        Product(10,"Smartwatch Fitnes",     "Elektronik", "Rp 1.200.000",  "⌚")
    )

    private lateinit var adapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup RecyclerView dengan LinearLayoutManager (vertikal)
        adapter = ProductAdapter(allProducts)
        binding.rvProducts.layoutManager = LinearLayoutManager(requireContext())
        binding.rvProducts.adapter = adapter

        // Tampilkan jumlah produk
        binding.tvProductCount.text = "Menampilkan ${allProducts.size} produk"

        // Fitur pencarian: filter produk berdasarkan teks input
        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filterProducts(s.toString())
            }
            override fun afterTextChanged(s: Editable?) {}
        })
    }

    // Filter produk berdasarkan nama atau kategori
    private fun filterProducts(query: String) {
        val filtered = if (query.isEmpty()) {
            allProducts
        } else {
            allProducts.filter { product ->
                product.name.contains(query, ignoreCase = true) ||
                product.category.contains(query, ignoreCase = true)
            }
        }
        // Buat adapter baru dengan hasil filter
        binding.rvProducts.adapter = ProductAdapter(filtered)
        binding.tvProductCount.text = "Menampilkan ${filtered.size} produk"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
