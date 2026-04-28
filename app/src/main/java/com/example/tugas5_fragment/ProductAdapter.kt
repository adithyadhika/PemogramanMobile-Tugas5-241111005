package com.example.tugas5_fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas5_fragment.databinding.ItemProductBinding

class ProductAdapter(private val products: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    // ViewHolder menyimpan referensi ke binding setiap item
    inner class ProductViewHolder(val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        with(holder.binding) {
            // Isi data ke tampilan
            tvProductEmoji.text    = product.emoji
            tvProductName.text     = product.name
            tvProductCategory.text = product.category
            tvProductPrice.text    = product.price

            // Tombol Beli: tampilkan Toast konfirmasi
            btnBuy.setOnClickListener {
                Toast.makeText(
                    holder.itemView.context,
                    "${product.name} ditambahkan ke keranjang 🛒",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun getItemCount(): Int = products.size
}
