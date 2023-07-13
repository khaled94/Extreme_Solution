package com.example.extreme_solution.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.extreme_solution.R
import com.example.extreme_solution.domain.entities.products.DomainProduct
import com.example.extreme_solution.databinding.FragmentHomeBinding
import com.example.extreme_solution.domain.entities.DomainDataState
import com.example.extreme_solution.presentation.common.BaseFragment
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomeFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var homeViewModel: HomeViewModel

    private var gridLayoutManager: GridLayoutManager? = null

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    var myProducts: List<DomainProduct> = listOf()
    private lateinit var adapter: HomeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.getAllProducts()
        gridLayoutManager = GridLayoutManager(requireContext(), 2)
        homeViewModel.productList.observe(viewLifecycleOwner) { dataState ->
            when (dataState) {
                is DomainDataState.Empty -> {

                }

                is DomainDataState.Loading -> {
                    handleLoadingState(true)
                }

                is DomainDataState.Error -> {
                    handleLoadingState(false)
                    handleError(dataState.exception.message!!)
                }

                is DomainDataState.Success -> {
                    handleLoadingState(false)
                    myProducts = dataState.data
                    myProducts = dataState.data
                    adapter = HomeAdapter(dataState.data) { product ->
                        selectProduct(product)
                    }
                    binding.rvProducts.adapter = adapter
                }
            }
        }

        binding.svProductName.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.svProductName.clearFocus()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return true
            }
        })

        val popupMenu = PopupMenu(requireContext(), binding.ivFilter)
        popupMenu.menuInflater.inflate(R.menu.category_menu, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener { menuItem ->
            val category = menuItem.title.toString()
            if (category == "All")
                (binding.rvProducts.adapter as HomeAdapter).updateData(myProducts)
            else
                (binding.rvProducts.adapter as HomeAdapter).updateData(
                    getProductsByCategory(
                        myProducts,
                        category
                    )
                )
            true
        }

        binding.ivFilter.setOnClickListener {
            popupMenu.show()
        }
    }

    private fun selectProduct(product: DomainProduct) {
        val bundle = Bundle().apply {
            putInt("productId", product.id)
        }
        findNavController().navigate(R.id.action_HomeFragment_to_DetailsFragment, bundle)
    }

    private fun getProductsByCategory(
        products: List<DomainProduct>,
        category: String
    ): List<DomainProduct> {

        return products.filter { it.category == category }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}