package com.example.extreme_solution.presentation.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.extreme_solution.databinding.FragmentDetailsBinding
import com.example.extreme_solution.domain.entities.DomainDataState
import com.example.extreme_solution.domain.entities.productDetails.ProductDetailsEntity
import com.example.extreme_solution.presentation.common.BaseFragment
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


class DetailsFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var detailsViewModel: DetailsViewModel

    private var _binding: FragmentDetailsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var product: ProductDetailsEntity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        detailsViewModel =
            ViewModelProvider(this, viewModelFactory)[DetailsViewModel::class.java]
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val productId = arguments?.getInt("productId")
        detailsViewModel.getProductDetails(productId!!)

        detailsViewModel.productDetails.observe(viewLifecycleOwner) { dataState ->
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
                    product = dataState.data
                   binding.tvTitle.text = product!!.title
                   binding.tvPrice.text = product!!.price.toString() +"$"
                   binding.tvCategory.text = product!!.category
                   binding.tvDescription.text = product!!.description
                   binding.tvRating.text = product!!.rating.count.toString()
                    Glide.with(binding.ivProductImage)
                        .load(product!!.image)
                        // .placeholder(R.drawable.placeholder_image)
                        // .error(R.drawable.error_image)
                        .into(binding.ivProductImage)
                }
            }
        }

        binding.btnAdd.setOnClickListener {
            val isSaved =  detailsViewModel.saveProductToDatabase(product!!)
            if(isSaved){
                //findNavController().popBackStack(com.example.extreme_solution.R.id.DetailsFragment, true)
                findNavController().navigate(com.example.extreme_solution.R.id.action_DetailsFragment_to_ShoppingCartFragment)
            }

        }
    }
}