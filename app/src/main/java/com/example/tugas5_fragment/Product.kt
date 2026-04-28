package com.example.tugas5_fragment

// Data class untuk merepresentasikan sebuah produk
data class Product(
    val id: Int,
    val name: String,       // Nama produk
    val category: String,   // Kategori produk
    val price: String,      // Harga dalam format Rupiah
    val emoji: String       // Ikon emoji produk
)
