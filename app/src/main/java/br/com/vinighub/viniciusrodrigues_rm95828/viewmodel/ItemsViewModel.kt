package br.com.vinighub.viniciusrodrigues_rm95828.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import br.com.vinighub.viniciusrodrigues_rm95828.data.DicasDao
import br.com.vinighub.viniciusrodrigues_rm95828.data.DicasDatabase
import br.com.vinighub.viniciusrodrigues_rm95828.model.DicasModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemsViewModel(application: Application) : AndroidViewModel(application) {

    private val itemDao: DicasDao

    val itemsLiveData: LiveData<List<DicasModel>>

    init {
        val database = Room.databaseBuilder(
            getApplication(),
            DicasDatabase::class.java,
            "dicas_database"
        ).build()

        itemDao = database.itemDao()

        itemsLiveData = itemDao.getAll()
    }

    fun addItem(title: String, description: String) {

        viewModelScope.launch(Dispatchers.IO) {
            val newItem = DicasModel(title = title, description = description)

            itemDao.insert(newItem)
        }
    }

    fun removeItem(item: DicasModel) {
        viewModelScope.launch(Dispatchers.IO) {
            itemDao.delete(item)
        }
    }
}