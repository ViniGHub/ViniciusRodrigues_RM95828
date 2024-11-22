package br.com.vinighub.viniciusrodrigues_rm95828.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import br.com.vinighub.viniciusrodrigues_rm95828.model.DicasModel

@Dao
interface DicasDao {

    @Query("SELECT * FROM DicasModel")
    fun getAll(): LiveData<List<DicasModel>>

    @Insert
    fun insert(item: DicasModel)

    @Delete
    fun delete(item: DicasModel)
}