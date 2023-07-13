package com.example.extreme_solution.presentation.common

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {


    private lateinit var loadingDialog: AlertDialog

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadingDialog = AlertDialog.Builder(requireContext())
            .setMessage("Loading...")
            .setCancelable(false)
            .create()

    }

    protected fun handleLoadingState(loadingState: Boolean) {
        if (loadingState) {
            loadingDialog.show()
        } else {
            loadingDialog.dismiss()
        }
    }

    protected fun handleError(errorMessage: String) {
        Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}
