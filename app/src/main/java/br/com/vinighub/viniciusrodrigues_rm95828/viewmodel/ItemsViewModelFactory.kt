package br.com.vinighub.viniciusrodrigues_rm95828.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ItemsViewModelFactory(private val application: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ItemsViewModel::class.java)) {
            // A anotação `@Suppress("UNCHECKED_CAST")` é usada para suprimir o aviso de cast inseguro.
            @Suppress("UNCHECKED_CAST")
            return ItemsViewModel(application) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}