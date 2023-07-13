package com.example.extreme_solution.presentation.shoppingCart

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.extreme_solution.databinding.FragmentShoppingCartBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ShoppingCartFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var shoppingCartViewModel: ShoppingCartViewModel


    private var _binding: FragmentShoppingCartBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    var totalPrice = 0.0

    private var gridLayoutManager: GridLayoutManager? = null
    private lateinit var adapter: ShoppingCartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        shoppingCartViewModel =
            ViewModelProvider(this, viewModelFactory)[ShoppingCartViewModel::class.java]
        _binding = FragmentShoppingCartBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shoppingCartViewModel.getAllProducts()
        gridLayoutManager = GridLayoutManager(requireContext(), 2)

        shoppingCartViewModel.productList.observe(viewLifecycleOwner) {

            for (product in it) {
                totalPrice += product.price
            }
            binding.tvTotalPrice.text = totalPrice.toString()
            adapter = ShoppingCartAdapter(it)
            binding.rvProducts.adapter = adapter
        }



    }

    //   binding..setOnClickListener {
    //  findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
    //   }

override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
}
}