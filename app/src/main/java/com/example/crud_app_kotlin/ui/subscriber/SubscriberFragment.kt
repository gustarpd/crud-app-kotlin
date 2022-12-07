package com.example.crud_app_kotlin.ui.subscriber
import AppDatabase
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.example.crud_app_kotlin.R
import com.example.crud_app_kotlin.Repository.DatabaseDataSource
import com.example.crud_app_kotlin.Repository.SubscriberRepository
import com.example.crud_app_kotlin.db.dao.SubscriberDao
import com.example.crud_app_kotlin.extension.hideKeboard
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_subscriber.*

class SubscriberFragment : Fragment(R.layout.fragment_subscriber) {

    private val viewModel: SubscriberViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val subscriberDAO: SubscriberDao =
                    AppDatabase.getInstance(requireContext()).subscriberDAO

                val repository: SubscriberRepository = DatabaseDataSource(subscriberDAO)
                return SubscriberViewModel(repository) as T
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeEvents()
        setListeners()
    }

    private fun observeEvents() {
        viewModel.subscriberStateEventData.observe(viewLifecycleOwner) { subscriberState ->
            when (subscriberState) {
                is SubscriberViewModel.SubscriberState.Inserted -> {
                    clearFields()
                    hideKeyboard()
                    requireView().requestFocus()
                }
            }
        }

        viewModel.messageEventData.observe(viewLifecycleOwner) { stringResId ->
            Snackbar.make(requireView(), stringResId, Snackbar.LENGTH_LONG).show()
        }
    }

    private fun clearFields() {
        input_name.text?.clear()
        input_email.text?.clear()
    }

    private fun hideKeyboard() {
        val parentActivity = requireActivity()
        if (parentActivity is AppCompatActivity) {
            parentActivity.hideKeboard()
        }
    }

    private fun setListeners() {
        button_subscriber.setOnClickListener {
            val name = input_name.text.toString()
            val email = input_email.text.toString()

            viewModel.addSubscriber(name, email)
        }
    }
}