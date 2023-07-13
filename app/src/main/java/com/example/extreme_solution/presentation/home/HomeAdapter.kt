package com.example.extreme_solution.presentation.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.extreme_solution.domain.entities.products.DomainProduct
import com.example.extreme_solution.databinding.ListItemClothesBinding
import com.example.extreme_solution.databinding.ListItemElectronicsBinding
import com.example.extreme_solution.databinding.ListItemJewelryBinding
import java.util.Locale

class HomeAdapter(
    private var products: List<DomainProduct> = listOf(),
    private val selectProduct: ((DomainProduct) -> Unit)? = null
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() , Filterable {

    private var adapterProducts: List<DomainProduct> = products


    inner class ElectronicsViewHolder(private val binding: ListItemElectronicsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: DomainProduct) {
            Glide.with(binding.ivProductImage)
                .load(product.image)
                // .placeholder(R.drawable.placeholder_image)
                // .error(R.drawable.error_image)
                .into(binding.ivProductImage)
            binding.tvTitle.text = product.title
            binding.tvPrice.text = product.price.toString()
            binding.root.setOnClickListener {
                selectProduct?.invoke(product)
            }
        }
    }

    inner class JewelryViewHolder(private val binding: ListItemJewelryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: DomainProduct) {
            Glide.with(binding.ivProductImage)
                .load(product.image)
                // .placeholder(R.drawable.placeholder_image)
                // .error(R.drawable.error_image)
                .into(binding.ivProductImage)
            binding.tvTitle.text = product.title
            binding.tvPrice.text = product.price.toString()
            binding.root.setOnClickListener {
                selectProduct?.invoke(product)
            }
        }
    }

    inner class ClothingViewHolder(private val binding: ListItemClothesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: DomainProduct) {
            Glide.with(binding.ivProductImage)
                .load(product.image)
                // .placeholder(R.drawable.placeholder_image)
                // .error(R.drawable.error_image)
                .into(binding.ivProductImage)
            binding.tvTitle.text = product.title
            binding.tvPrice.text = product.price.toString()
            binding.root.setOnClickListener {
                selectProduct?.invoke(product)
            }
        }
    }

    companion object {
        private const val VIEW_TYPE_ELECTRONICS = 1
        private const val VIEW_TYPE_JEWELRY = 2
        private const val VIEW_TYPE_CLOTHING = 3
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val electronicsBinding = ListItemElectronicsBinding.inflate(inflater, parent, false)
        val jewelryBinding = ListItemJewelryBinding.inflate(inflater, parent, false)
        val clothesBinding = ListItemClothesBinding.inflate(inflater, parent, false)
        return when (viewType) {
            VIEW_TYPE_ELECTRONICS -> ElectronicsViewHolder(electronicsBinding)
            VIEW_TYPE_JEWELRY -> JewelryViewHolder(jewelryBinding)
            VIEW_TYPE_CLOTHING -> ClothingViewHolder(clothesBinding)
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    fun updateData(products: List<DomainProduct>) {
        this.products = products
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val query = constraint.toString().lowercase(Locale.getDefault())
                var filteredList = mutableListOf<DomainProduct>()

                if (query.isNotEmpty()) {
                    for (product in adapterProducts) { // Search the original list
                        if (product.title.lowercase(Locale.getDefault()).contains(query)) {
                            filteredList.add(product)
                        }
                    }
                }
                else {
                    filteredList.addAll(adapterProducts) // If the search query is empty, display the original list
                }

                val results = FilterResults()
                results.values = filteredList
                results.count = filteredList.size
                return results
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                products = results?.values as List<DomainProduct>
                notifyDataSetChanged()
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
                val product = products[position]
                when (holder.itemViewType) {
                    VIEW_TYPE_ELECTRONICS -> {
                        val electronicsHolder = holder as ElectronicsViewHolder
                        electronicsHolder.bind(product)
                    }

                    VIEW_TYPE_JEWELRY -> {
                        val jewelryHolder = holder as JewelryViewHolder
                        jewelryHolder.bind(product)
                    }

                    VIEW_TYPE_CLOTHING -> {
                        val clothingHolder = holder as ClothingViewHolder
                        clothingHolder.bind(product)
                    }
                }
            }

            override fun getItemCount() = products.size


            override fun getItemViewType(position: Int): Int {
                val product = products[position]
                return when (product.category) {
                    "electronics" -> VIEW_TYPE_ELECTRONICS
                    "jewelery" -> VIEW_TYPE_JEWELRY
                    "men's clothing", "women's clothing" -> VIEW_TYPE_CLOTHING
                    else -> VIEW_TYPE_ELECTRONICS

                }
            }
        }
